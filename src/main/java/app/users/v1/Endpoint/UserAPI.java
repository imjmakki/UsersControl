package app.users.v1.Endpoint;

import app.users.v1.Domain.User;
import app.users.v1.Service.UserService;
import app.users.v1.Utility.Config.HttpResponse;
import app.users.v1.Utility.Config.UserPrincipal;
import app.users.v1.Utility.Constant.EmailConstant;
import app.users.v1.Utility.Constant.UserImplConstant;
import app.users.v1.Utility.Exception.ExceptionHandling;
import app.users.v1.Utility.Exception.User.*;
import app.users.v1.Utility.Filter.JWTTokenProvider;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

import java.io.IOException;
import java.util.List;

import static app.users.v1.Utility.Constant.SecurityConstant.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = {"/", "/user"})
@CrossOrigin(origins = "*")
public class UserAPI extends ExceptionHandling {
    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    public UserAPI(AuthenticationManager authenticationManager, UserService userService, JWTTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        authenticate(user.getUsername(), user.getPassword());
        User loginUser = userService.findUserByUsername(user.getUsername());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return new ResponseEntity<>(loginUser, jwtHeader, OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, IOException {
        User newUser = userService.register(user.getUsername(), user.getEmail(), user.getPassword());
        return new ResponseEntity<>(newUser, OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestParam("username") String username,
                                           @RequestParam("email") String email,
                                           @RequestParam("password") String password,
                                           @RequestParam("role") String role,
                                           @RequestParam("isActive") String isActive,
                                           @RequestParam("isNotLocked") String isNotLocked) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, MessagingException {
        User newUser = userService.addNewUser(username,email, password, role, Boolean.parseBoolean(isNotLocked), Boolean.parseBoolean(isActive));
        return new ResponseEntity<>(newUser, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestParam("currentUsername") String currentUsername,
                                       @RequestParam("username") String username,
                                       @RequestParam("email") String email,
                                       @RequestParam("role") String role,
                                       @RequestParam("isActive") String isActive,
                                       @RequestParam("isNotLocked") String isNotLocked) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, EmailExistException, UsernameExistException {
        User updatedUser = userService.updateUser(currentUsername, username,email, role, Boolean.parseBoolean(isNotLocked), Boolean.parseBoolean(isActive));
        return new ResponseEntity<>(updatedUser, OK);
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        User user = userService.findUserByUsername(username);
        return new ResponseEntity<>(user, OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, OK);
    }

    @GetMapping("/reset/{email}")
    public ResponseEntity<HttpResponse> resetPassword(@PathVariable("email") String email) throws MessagingException, EmailNotFoundException, EmailNotFoundException {
        userService.resetPassword(email);
        return response(OK, EmailConstant.EMAIL_SENT + email);
    }

    @DeleteMapping("/delete/{username}")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public ResponseEntity<HttpResponse> deleteUser(@PathVariable("username") String username) throws IOException {
        userService.deleteUser(username);
        return response(OK, UserImplConstant.USER_DELETED_SUCCESSFULLY);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                message), httpStatus);
    }

    private HttpHeaders getJwtHeader(UserPrincipal user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
        return headers;
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}

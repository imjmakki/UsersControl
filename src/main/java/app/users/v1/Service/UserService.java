package app.users.v1.Service;

import app.users.v1.Domain.User;
import app.users.v1.Utility.Exception.User.*;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Service
public interface UserService {

    List<User> getUsers();
    User findUserByUsername(String username);
    User findUserByEmail(String email);

    User register(String username, String email, String password) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;
    User addNewUser(String username, String email, String password, String role, boolean isNotLocked, boolean isActive) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, MessagingException;
    User updateUser(String currentUsername, String newUsername, String newEmail, String role, boolean isNotLocked, boolean isActive) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;

    void deleteUser(String username);
    void resetPassword(String email) throws MessagingException, EmailNotFoundException;
}

package app.users.v1.Utility.Implement;

import app.users.v1.Domain.User;
import app.users.v1.Service.UserService;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User register(String username, String email, String password) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException {
        return null;
    }

    @Override
    public User addNewUser(String username, String email, String password, String role, boolean isNotLocked, boolean isActive) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, MessagingException {
        return null;
    }

    @Override
    public User updateUser(String currentUsername, String newUsername, String newEmail, String role, boolean isNotLocked, boolean isActive) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException {
        return null;
    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void resetPassword(String email) throws MessagingException, EmailNotFoundException {

    }
}

package app.users.v1.Utility.Exception.User;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class UsernameNotExistException extends Exception{
}

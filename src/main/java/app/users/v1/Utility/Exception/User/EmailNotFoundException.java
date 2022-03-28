package app.users.v1.Utility.Exception.User;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@ResponseStatus(NOT_FOUND)
public class EmailNotFoundException extends Exception{

    public EmailNotFoundException(String message) {
        super(message);
    }
}

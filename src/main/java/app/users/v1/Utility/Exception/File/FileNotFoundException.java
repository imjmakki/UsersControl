package app.users.v1.Utility.Exception.File;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class FileNotFoundException extends Exception{

    public FileNotFoundException(String message) {
        super(message);
    }
}

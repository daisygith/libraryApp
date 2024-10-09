package sdu.libraryApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DataBaseAdvice {
    @ResponseBody
    @ExceptionHandler(DataBaseException.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String DataBaseHandler(DataBaseException ex){
        return ex.getMessage();
    }
}

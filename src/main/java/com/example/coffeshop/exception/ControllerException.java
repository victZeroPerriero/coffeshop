package com.example.coffeshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerException {
    @ExceptionHandler(ResorceNotFound.class)
    public ResponseEntity <ErrorMessage> resFoundExcep(ResorceNotFound exc, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                new Date(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
}

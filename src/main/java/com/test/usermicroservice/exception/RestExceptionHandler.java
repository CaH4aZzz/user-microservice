package com.test.usermicroservice.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @Value ("${usermicroservice.api.version}")
    private String currentApiVersion;

    @ExceptionHandler (NonExistingUserException.class)
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public ResponseEntity<AppError> handleNonExistingEntity(NonExistingUserException ex) {
        AppError error = new AppError(
                currentApiVersion,
                String.valueOf(HttpStatus.NOT_FOUND.value()),
                ex.getLocalizedMessage(),
                ex.getStackTrace()[0].getFileName() + " line " + ex.getStackTrace()[0].getLineNumber(),
                "User with specified ID doesn't exists",
                "More specific error message"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

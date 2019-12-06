package com.test.usermicroservice.exception;

public class NonExistingUserException extends RuntimeException{

    public NonExistingUserException(String message) {
        super(message);
    }
}

package com.test.usermicroservice.exception;

import com.test.usermicroservice.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class UserExceptionController {

//    @ExceptionHandler(value = EntityNotFoundException.class)
//    public RequestEntity<Object> exception(EntityNotFoundException ex){
//        return new RequestEntity<>("User not found", HttpStatus.NOT_FOUND);
//    }
}

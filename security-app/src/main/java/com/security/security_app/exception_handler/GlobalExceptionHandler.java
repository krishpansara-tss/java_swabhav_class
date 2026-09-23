package com.security.security_app.exception_handler;

import com.security.security_app.exceptions.UserApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<UserApiException> handleUserNotFound(UserNotFoundException ex) {
//        UserApiException error = new UserApiException(
//                HttpStatus.NOT_FOUND.value(), ex.getMessage()
//        );
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); }
}

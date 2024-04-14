package com.test.wastemanageraddressservice.controller;

import com.test.wastemanageraddressservice.exceptions.ApiError;
import com.test.wastemanageraddressservice.exceptions.CreateException;
import com.test.wastemanageraddressservice.exceptions.NoValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = NoValueException.class)
    public ResponseEntity<ApiError> handleNoUserException(NoValueException noUserException){
         ApiError error = new ApiError(400, noUserException.getMessage(), new Date());
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CreateException.class)
    public ResponseEntity<ApiError> handleCreateUserException(CreateException createException){
        ApiError error = new ApiError(400, createException.getMessage(), new Date());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

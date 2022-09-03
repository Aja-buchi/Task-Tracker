package com.example.todo.controller;

import com.example.todo.exceptions.TaskNotFoundException;
import com.example.todo.exceptions.UserAlreadyExists;
import com.example.todo.exceptions.UserNotFoundException;
import com.example.todo.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(final UserNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("The user with this id does not exist");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(final UserAlreadyExists ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("This email already exists. Please check the email you inputted");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTaskNotFoundException(final TaskNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("This task does not exist");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}

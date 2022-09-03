package com.example.todo.exceptions;

public class TaskAlreadyExist extends RuntimeException{
    public TaskAlreadyExist(final String message) {
        super(message);
    }
}

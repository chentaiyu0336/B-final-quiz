package com.example.demo.exception;

public class GroupNotExistException extends RuntimeException {
    public GroupNotExistException(String message) {
        super(message);
    }
}

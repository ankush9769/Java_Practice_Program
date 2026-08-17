package com.example.demo.exception;

public class EmployeeNotExistException extends RuntimeException {
    public EmployeeNotExistException(String message) {
        super(message);
    }
}

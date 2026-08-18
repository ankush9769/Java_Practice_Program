package com.example.FileManagementSpringbootapp8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleFileNotFound(FileNotFoundException ex){
        Map<String,String> error=new HashMap<>();

        error.put("message",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,String>> handleIllegalArgument(IllegalArgumentException ex){
        Map<String,String> error = new HashMap<>();
        error.put("Message",ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}

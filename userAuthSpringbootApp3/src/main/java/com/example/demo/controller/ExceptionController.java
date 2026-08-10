package com.example.demo.controller;

import com.example.demo.exception.EmployeeNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(EmployeeNotExistException.class)
    public String error(Exception e){
        return "404page";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e){
        return "404page";
    }
}

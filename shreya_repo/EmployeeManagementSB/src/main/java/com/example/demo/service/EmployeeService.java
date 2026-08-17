package com.example.demo.service;


import com.example.demo.entities.Employees;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface EmployeeService {

     List<Employees> searchEmployees(String keyword);


    @Transactional(readOnly = true)
    Boolean emailExists(String email);

    Employees saveEmployee(Employees employees);

    Employees getEmployeeById(Long id);

    Boolean emailExistsForAnotherEmployee(String email ,Long id);

    Employees updateEmployee(Long id, Employees employees);

    void deleteEmployee(Long id);


}


package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    EmpRepo empRepo;

    public void save(Employee employee){
        empRepo.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return empRepo.findAll();
    }
}

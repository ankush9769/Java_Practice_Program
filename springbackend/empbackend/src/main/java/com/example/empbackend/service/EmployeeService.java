package com.example.empbackend.service;


import com.example.empbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee postEmployee(Employee emp);
    public void deleteEmployee(int id);


}

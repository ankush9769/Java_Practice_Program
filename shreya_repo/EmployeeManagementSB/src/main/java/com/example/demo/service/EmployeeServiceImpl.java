package com.example.demo.service;

import com.example.demo.entities.Employees;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }

    @Override
    public List<Employees> searchEmployees(String keyword) {
        if (keyword==null || keyword.trim().isEmpty()){
            return employeeRepo.findAll();
        }
        String cleanedKeyword= keyword.trim();

        return  employeeRepo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(cleanedKeyword,cleanedKeyword);


    }

    @Transactional(readOnly = true)
    @Override
    public Boolean emailExists(String email) {
        return employeeRepo.existsByEmailIgnoreCase(email);
    }

    @Override
    public Employees saveEmployee(Employees employees) {
        if (employees.getActive()== null){
            employees.setActive(false);
        }
        return employeeRepo.save(employees);
    }

    @Override
    public Employees getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("employee not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean emailExistsForAnotherEmployee(String email, Long id) {
        Optional<Employees> employeesOptional= employeeRepo.findByEmailIgnoreCase(email);
        if (employeesOptional.isEmpty()){
            return false;  // means email id doesnt already exist
        }

        Employees employeesWithSameEmail= employeesOptional.get();
        return !employeesWithSameEmail.getId().equals(id);
    }

    @Override
    public Employees updateEmployee(Long id, Employees employees) {
        Employees existingEmployee = getEmployeeById(id);

        existingEmployee.setFirstName(employees.getFirstName());
        existingEmployee.setLastName(employees.getLastName());
        existingEmployee.setEmail(employees.getEmail());
        existingEmployee.setDepartment(employees.getDepartment());
        existingEmployee.setDesignation(employees.getDesignation());
        existingEmployee.setSalary(employees.getSalary());

        existingEmployee.setActive(employees.getActive()!=null? employees.getActive():false);
        return  employeeRepo.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employees employees = getEmployeeById(id);
       employeeRepo.delete(employees);
    }


}

package com.example.demo.repository;

import com.example.demo.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees,Long> {

    public List<Employees> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
    public Boolean existsByEmailIgnoreCase(String email);
    public Optional<Employees> findByEmailIgnoreCase(String email);
}

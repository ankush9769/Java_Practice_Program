package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name required")
    @Size(min = 2,max = 50,
    message = "First name should contain between 2 and 50 characters")
    @Column(name = "first_name", nullable = false,length = 50)
    private String firstName;

    @NotBlank(message = "Last Name required")
    @Size(min = 2,max = 50,
            message = "Last name should contain between 2 and 50 characters")
    @Column(name = "last_name", nullable = false,length = 50)// JPA NOT Validations
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Department is required")
    @Column(nullable = false)
    private String department;

    @NotBlank(message = "Designation is required")
    @Column(nullable = false)
    private String designation;

    @Column(nullable = false) // jpa
    @Positive(message = "salary must be greater than 0")
    private Double salary;

    @Column(name = "active", nullable = false)
    private Boolean active= true;


}

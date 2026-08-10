package com.example.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name is required")
    @Size(min = 3,max = 50,message = "name must be between 3 and 50 character")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "please entere valid email id")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8,max = 20,message = "password must contains between 8 to 20 charactere")
    private String password;

    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "^[0-9]{10}$",
    message = "phone number must contains exactly 10 digits")
    private String phoneNumber;

    @Min(value = 18,message = "age must be at least 18")
    @Max(value = 60,message = "agen cannot be greater than 60")
    private Integer age;   //Because `Integer` allows null values

    @Positive(message = "salary must be greater than 0")
    private Double salary;

    @NotBlank(message = "Department is required")
    private String department;
}

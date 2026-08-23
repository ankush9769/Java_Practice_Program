package com.example.AssignmentTrackingSpringBootApp11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean active;

    private Date createdAt;
    
    private Date updatedAt;
}

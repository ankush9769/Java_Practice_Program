package com.example.UserAuthenticaionSpringBootApp12.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(nullable = true)
    private String provider;

    @Column(nullable = true)
    private String providerId;

}

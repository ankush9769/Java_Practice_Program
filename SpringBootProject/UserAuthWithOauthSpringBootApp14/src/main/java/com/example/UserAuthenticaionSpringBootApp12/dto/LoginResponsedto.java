package com.example.UserAuthenticaionSpringBootApp12.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponsedto {
    private Long id;
    private String username;
    private String email;
    private String role;
    private String token;
}

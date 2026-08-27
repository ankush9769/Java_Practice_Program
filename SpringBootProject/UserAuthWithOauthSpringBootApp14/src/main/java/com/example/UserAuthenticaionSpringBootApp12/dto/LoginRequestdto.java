package com.example.UserAuthenticaionSpringBootApp12.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestdto {
    @NotBlank(message = "cant be blank")
    @Email(message = "follow email convention")
    private String email;
    @NotBlank(message = "cant be blank")
    private String password;
}

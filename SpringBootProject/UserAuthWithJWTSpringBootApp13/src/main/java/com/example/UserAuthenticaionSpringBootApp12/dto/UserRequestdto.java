package com.example.UserAuthenticaionSpringBootApp12.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestdto {
    @NotBlank(message = "cant be black")
    @Size(min = 5,max = 20,message = "follow the range of size")
    private String username;

    @NotBlank(message = "cant be black")
    private String password;

    @NotBlank(message = "cant be black")
    @Email(message = "follow email convention")
    private String email;

    @NotBlank(message = "cant be black")
    private String role;

}

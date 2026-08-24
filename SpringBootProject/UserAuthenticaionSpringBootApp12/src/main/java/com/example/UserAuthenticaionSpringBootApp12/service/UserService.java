package com.example.UserAuthenticaionSpringBootApp12.service;

import com.example.UserAuthenticaionSpringBootApp12.dto.UserRequestdto;
import com.example.UserAuthenticaionSpringBootApp12.dto.UserResponsedto;
import com.example.UserAuthenticaionSpringBootApp12.entity.UserAuth;

import java.util.List;

public interface UserService {
    public UserResponsedto registration(UserRequestdto requestdto);
    public List<UserResponsedto> findAll();
    public UserResponsedto findById(Long id);
}

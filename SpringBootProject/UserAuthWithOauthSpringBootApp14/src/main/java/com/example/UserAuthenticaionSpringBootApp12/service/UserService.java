package com.example.UserAuthenticaionSpringBootApp12.service;

import com.example.UserAuthenticaionSpringBootApp12.dto.*;
import com.example.UserAuthenticaionSpringBootApp12.entity.UserAuth;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    public UserResponsedto registration(UserRequestdto requestdto);
    public List<UserResponsedto> findAll();
    public UserResponsedto findById(Long id);
    public LoginResponsedto login(LoginRequestdto loginrequest);
    public UserResponsedto update(UpdateRequestdto updateRequestdto, UserDetails userDetails);
    public UserResponsedto getUserProfile(String username);

}

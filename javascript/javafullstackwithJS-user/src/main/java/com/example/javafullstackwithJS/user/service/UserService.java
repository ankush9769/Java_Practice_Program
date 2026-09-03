package com.example.javafullstackwithJS.user.service;

import com.example.javafullstackwithJS.user.Entity.Users;
import com.example.javafullstackwithJS.user.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService{
    public Users createUser(Users user);
    public List<Users> findAll();

}

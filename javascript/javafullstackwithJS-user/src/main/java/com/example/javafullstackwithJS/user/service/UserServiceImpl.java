package com.example.javafullstackwithJS.user.service;

import com.example.javafullstackwithJS.user.Entity.Users;
import com.example.javafullstackwithJS.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public Users createUser(Users user) {
        return userRepo.save(user);
    }

    @Override
    public List<Users> findAll() {
        List<Users> userlist = userRepo.findAll();
        return userlist;
    }
}

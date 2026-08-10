package com.example.demo.service;

import com.example.demo.entities.Users;
import com.example.demo.exception.EmployeeNotExistException;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    UserRepo userRepo;

    public  Users addUser(Users users){
        return userRepo.save(users);
    }

    public Users checkUser(Users users){
        Users userss = userRepo.findByEmailAndPassword(users.getEmail(), users.getPassword());
        if(userss != null){
            return userss;
        }else{
            throw new EmployeeNotExistException("employe not found");
        }
    }

}

package com.example.javafullstackwithJS.user.controller;

import com.example.javafullstackwithJS.user.Entity.Users;
import com.example.javafullstackwithJS.user.repo.UserRepo;
import com.example.javafullstackwithJS.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepo userRepo;

    @PostMapping
    public Users craeteUser(@RequestBody Users user){
        Users users = userService.createUser(user);
        return users;
    }

    @GetMapping
    public List<Users> findall(){
        List<Users> userlist = userService.findAll();
        return userlist;
    }


}

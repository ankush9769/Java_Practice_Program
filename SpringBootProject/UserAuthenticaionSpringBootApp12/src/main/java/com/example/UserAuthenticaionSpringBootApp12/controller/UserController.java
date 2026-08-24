package com.example.UserAuthenticaionSpringBootApp12.controller;

import com.example.UserAuthenticaionSpringBootApp12.dto.UserRequestdto;
import com.example.UserAuthenticaionSpringBootApp12.dto.UserResponsedto;
import com.example.UserAuthenticaionSpringBootApp12.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userauth")
public class UserController {
    @Autowired
    UserServiceImpl userService;


    @GetMapping("/getting")
    public String getting(){
        return "hello how are you";
    }

    @PostMapping("/registration")
    public ResponseEntity<UserResponsedto> registration(@Valid @RequestBody UserRequestdto request){
        UserResponsedto responsedto = userService.registration(request);
        return ResponseEntity.ok(responsedto);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<UserResponsedto>> findAll(){
        List<UserResponsedto> response = userService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<UserResponsedto> findById(@PathVariable Long id){
        UserResponsedto response = userService.findById(id);
        return ResponseEntity.ok(response);
    }
}

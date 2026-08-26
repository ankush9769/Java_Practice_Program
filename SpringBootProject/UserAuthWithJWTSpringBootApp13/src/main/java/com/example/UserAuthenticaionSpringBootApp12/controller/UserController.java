package com.example.UserAuthenticaionSpringBootApp12.controller;

import com.example.UserAuthenticaionSpringBootApp12.dto.*;
import com.example.UserAuthenticaionSpringBootApp12.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userauth")
public class UserController {

   private final UserServiceImpl userService;




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


    @PostMapping("/login")
    public ResponseEntity<LoginResponsedto> login(
            @RequestBody LoginRequestdto loginrequest){
        LoginResponsedto responsedto = userService.login(loginrequest);
        return ResponseEntity.ok(responsedto);
    }

    @PatchMapping("/update")
    public ResponseEntity<UserResponsedto> update(@RequestBody UpdateRequestdto updateRequestdto,@AuthenticationPrincipal UserDetails userDetails){
        UserResponsedto userAuthResponseDto= userService.update(updateRequestdto,userDetails);
        return ResponseEntity.ok(userAuthResponseDto);
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponsedto> profile(@AuthenticationPrincipal UserDetails userDetails){
        System.out.println("--------------------------------------");
        return ResponseEntity.ok(userService.getUserProfile(userDetails.getUsername()));
    }
}

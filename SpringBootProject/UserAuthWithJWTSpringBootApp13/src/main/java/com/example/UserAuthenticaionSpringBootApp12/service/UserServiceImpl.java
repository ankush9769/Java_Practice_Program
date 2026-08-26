package com.example.UserAuthenticaionSpringBootApp12.service;

import com.example.UserAuthenticaionSpringBootApp12.customeJWT.JwtService;
import com.example.UserAuthenticaionSpringBootApp12.dto.*;
import com.example.UserAuthenticaionSpringBootApp12.entity.UserAuth;
import com.example.UserAuthenticaionSpringBootApp12.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;


    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public UserResponsedto registration(UserRequestdto requestdto) {
        UserAuth user = modelMapper.map(requestdto,UserAuth.class);
        user.setPassword(passwordEncoder.encode(requestdto.getPassword()));//Encoded the password

      UserAuth userAuth =  userRepo.save(user);
      return modelMapper.map(userAuth, UserResponsedto.class);

    }

    @Override
    public List<UserResponsedto> findAll() {
        List<UserAuth> listuser = userRepo.findByRole("USER");
        List<UserResponsedto> listresponse = new ArrayList<>();
        for (UserAuth user:listuser){
            UserResponsedto userResponsedto = modelMapper.map(user,UserResponsedto.class);
            listresponse.add(userResponsedto);
        }
        return listresponse;
    }

    @Override
    public UserResponsedto findById(Long id) {
        UserAuth user = userRepo.findById(id).orElseThrow(()->{
            throw  new RuntimeException();
        });
        return modelMapper.map(user,UserResponsedto.class);
    }

    @Override
    public LoginResponsedto login(LoginRequestdto loginrequest) {
        try{
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(loginrequest.getEmail(),loginrequest.getPassword()));
        }catch (AuthenticationException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"invalid username password");
        }
        UserAuth getuser = userRepo.findByEmailIgnoreCase(loginrequest.getEmail())
                .orElseThrow(()->new UsernameNotFoundException("id password did not match"));
        LoginResponsedto loginResponsedto = modelMapper.map(getuser,LoginResponsedto.class);
        loginResponsedto.setToken(jwtService.generateToken(getuser.getEmail(),getuser.getRole()));
        return loginResponsedto;
    }

    @Override
    public UserResponsedto update(UpdateRequestdto updateRequestdto, UserDetails userDetails) {
        UserAuth user = userRepo.findByEmailIgnoreCase(userDetails.getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("User not available"));

        user.setUsername(updateRequestdto.getUsername());
        user.setEmail(updateRequestdto.getEmail());
        user.setPassword(passwordEncoder.encode(updateRequestdto.getPassword()));

        UserAuth userAuthEntity= userRepo.save(user);
        return modelMapper.map(userAuthEntity,UserResponsedto.class);
    }

    @Override
    public UserResponsedto getUserProfile(String username) {
        System.out.println("-----------------"+username);
        UserAuth getuser = userRepo.findByEmailIgnoreCase(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        System.out.println("from service-----------------------------------------");
        return modelMapper.map(getuser,UserResponsedto.class);
    }




}

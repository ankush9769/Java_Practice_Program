package com.example.UserAuthenticaionSpringBootApp12.service;

import com.example.UserAuthenticaionSpringBootApp12.config.ModelMapperConfig;
import com.example.UserAuthenticaionSpringBootApp12.config.SecurityFilterConfig;
import com.example.UserAuthenticaionSpringBootApp12.dto.UserRequestdto;
import com.example.UserAuthenticaionSpringBootApp12.dto.UserResponsedto;
import com.example.UserAuthenticaionSpringBootApp12.entity.UserAuth;
import com.example.UserAuthenticaionSpringBootApp12.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SecurityFilterConfig securityFilterConfig;

    @Override
    public UserResponsedto registration(UserRequestdto requestdto) {
        UserAuth user = modelMapper.map(requestdto,UserAuth.class);
        user.setPassword(securityFilterConfig.passwordEncoder().encode(requestdto.getPassword()));//Encoded the password

      UserAuth userAuth =  userRepo.save(user);
      return modelMapper.map(userAuth, UserResponsedto.class);

    }

    @Override
    public List<UserResponsedto> findAll() {
        List<UserAuth> listuser = userRepo.findAll();
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


}

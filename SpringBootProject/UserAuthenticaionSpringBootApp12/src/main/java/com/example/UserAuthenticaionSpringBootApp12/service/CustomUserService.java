package com.example.UserAuthenticaionSpringBootApp12.service;

import com.example.UserAuthenticaionSpringBootApp12.entity.UserAuth;
import com.example.UserAuthenticaionSpringBootApp12.repo.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {
    private final UserRepo userRepo;

    public CustomUserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuth = userRepo.findByEmail(username).get();
        UserDetails userDetails = User.builder().username(userAuth.getUsername()).password(userAuth.getPassword()).roles(userAuth.getRole()).build();
        return userDetails;
    }
}

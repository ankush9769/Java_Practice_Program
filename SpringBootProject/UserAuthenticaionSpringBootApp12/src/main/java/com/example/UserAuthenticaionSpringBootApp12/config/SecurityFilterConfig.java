package com.example.UserAuthenticaionSpringBootApp12.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterConfig {
    @Bean
    public SecurityFilterChain getfilterchain(HttpSecurity httpSecurity){
        //disable csrf
        httpSecurity.csrf(csrf->csrf.disable()); //

        httpSecurity.authorizeHttpRequests(request->//Allowing all the users for registration
                request.requestMatchers("/userauth/registration").permitAll().anyRequest().authenticated()); //Register endpoint API कोई भी hit कर सकता है। उसके अलावा और कोई भी endpoint है तो वो authenticated होगा।

        httpSecurity.formLogin(Customizer.withDefaults());// browser -> form
        httpSecurity.httpBasic(Customizer.withDefaults());// postman -> httpbasic
        //nothing changes as it is

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

package com.example.UserAuthenticaionSpringBootApp12.config;


import com.example.UserAuthenticaionSpringBootApp12.OauthHandler.OAuth2LoginSuccessHandler;
import com.example.UserAuthenticaionSpringBootApp12.customeJWT.JwtService;
import com.example.UserAuthenticaionSpringBootApp12.filter.JwtAuthFilter;
import com.example.UserAuthenticaionSpringBootApp12.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityFilterConfig {
    @Bean
    public SecurityFilterChain getfilterchain(HttpSecurity httpSecurity,
                                              JwtService jwtService,
                                              CustomUserService customUserService,
                                              AuthenticationEntryPoint authenticationEntryPoint,
                                              OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler
    ){

        JwtAuthFilter jwtAuthFilter = new JwtAuthFilter(jwtService,customUserService);
        //disable csrf
        httpSecurity.csrf(csrf->csrf.disable());

        httpSecurity.authorizeHttpRequests(request->//Allowing all the users for registration
                request.requestMatchers("/userauth/registration","/userauth/login"
                                ,"/oauth2/**"//mainly used to start Oauth autentication
                                ,"/login/**")//contains spring security oatuth callback url
                                .permitAll()
                       // .requestMatchers("/userauth/login").permitAll()
                        .requestMatchers("/userauth/me").authenticated()
                        .requestMatchers("/userauth/findbyid/{id}").hasRole("ADMIN")
                        .requestMatchers("/userauth/findall").hasRole("ADMIN")
                        .anyRequest().authenticated())
                ; //Register endpoint API कोई भी hit कर सकता है। उसके अलावा और कोई भी endpoint है तो वो authenticated होगा।

        //jwt part(making session stateless)
        httpSecurity.sessionManagement(httpSecuritySessionManagementConfigurer ->
                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(ex->ex.authenticationEntryPoint(authenticationEntryPoint))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(oauth2->oauth2.successHandler(oAuth2LoginSuccessHandler));

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(CustomUserService customUserService,PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(customUserService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public AuthenticationEntryPoint jwtAuthenticationEntryPoint(){
        return ((request, response, authException) -> {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write("{\"Status\":401,\"error\":\"Unauthorized\","
            +"\"message\":\"missing or invalid bearer token\"}");
        });
    }
}

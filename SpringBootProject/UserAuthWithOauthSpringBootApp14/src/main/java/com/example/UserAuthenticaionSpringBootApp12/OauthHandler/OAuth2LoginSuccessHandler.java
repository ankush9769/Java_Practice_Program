package com.example.UserAuthenticaionSpringBootApp12.OauthHandler;

import com.example.UserAuthenticaionSpringBootApp12.customeJWT.JwtService;
import com.example.UserAuthenticaionSpringBootApp12.entity.UserAuth;
import com.example.UserAuthenticaionSpringBootApp12.repo.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {
    private static final String PROVIDER = "GITHUB";
    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

//    github return something like this
//    {
//        "id":12345789,
//        "login":"rolipandey",---username
//        "email":"roli@gmail.com",
//        "name":"roli pandey"
//    }

    //Once authentication is completed from GitHub ,onAuthenticationSuccess receive authentication object
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal(); //currently autgenticated user
        Object id = oAuth2User.getAttribute("id");//github + provider uniquelry identifies the github account
        String providerId = String.valueOf(id);
        String login = oAuth2User.getAttribute("login"); //username
        String email = oAuth2User.getAttribute("email");//email

        if (email == null)//if user public email is hidden/not pyblic by provider
            email = providerId + "+" + login + "@users.noreply.github.com";// to create an email-like identifies for our app

        UserAuth userAuth = findOrCreate(providerId, login, email);//if eixsting ,return updated details/ for 1st time customer,
        //create/register new info

        String token = jwtService.generateToken(userAuth.getEmail(), userAuth.getRole());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(
                """
                        {
                        "token":"%s",
                        "email":"%s"
                        }""".formatted(token, userAuth.getEmail())
        );
    }
    private UserAuth findOrCreate(String providerId,String login,String email){
        return userRepo.findByProviderAndProviderId(PROVIDER,providerId)
                .orElseGet(()->
                        userRepo.findByEmailIgnoreCase(email)
                                .map(existing->{
                                    existing.setProviderId(providerId);
                                    existing.setProvider(PROVIDER);
                                    return userRepo.save(existing);
                                })
                                .orElseGet(()->
                                        userRepo.save(
                                                UserAuth.builder()
                                                        .username(login)
                                                        .email(email)
                                                        .role("USER")//default role for any user coming from 3rd party vendor api
                                                        .password(
                                                                passwordEncoder.encode(
                                                                        UUID.randomUUID().toString()
                                                                )
                                                        )
                                                        .providerId(providerId)
                                                        .provider(PROVIDER)
                                                        .build()
                                        )
                                )
                );
    }
}

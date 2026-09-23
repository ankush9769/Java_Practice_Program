package com.example.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public Map<String, Object> profile(
            Authentication authentication
    ) {
        return Map.of(
                "message", "You are authenticated",
                "email", authentication.getName()
        );
    }
}

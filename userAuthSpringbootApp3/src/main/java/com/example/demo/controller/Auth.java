package com.example.demo.controller;

import com.example.demo.entities.Users;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Auth {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String registerpage(Model model){
        model.addAttribute("users",new Users());
        return "registerUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute Users users,Model model){
        Users users1 = userService.addUser(users);
        if(users1 != null){
            model.addAttribute("success","user register successfully");
        }else{
            model.addAttribute("failed","user register faied");
        }
        return "registerUser";
    }

    @GetMapping("/login")
    public String loginpage(Model model){
        model.addAttribute("users",new Users());
        return "loginUser";
    }

    @PostMapping("/authorize")
    public String loginUser(@ModelAttribute Users loginUser, RedirectAttributes redirectAttributes){
        Users validUser = userService.checkUser(loginUser);
        if(validUser != null){
            redirectAttributes.addFlashAttribute("name",validUser.getName());
            return "redirect:/profile";
        }else{
            redirectAttributes.addFlashAttribute("failed","login failed");
            return "redirect:/loginUser";
        }
    }
    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/login";

    }
}

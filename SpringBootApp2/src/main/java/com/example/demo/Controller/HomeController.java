package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/openprofile")
    public String openProfile(Model model){
        String name = "ankush";
        model.addAttribute("key",name);
        return "profile";
    }

    @GetMapping("/greaterNum")
    public String greaterNum(Model model){
        int num1 = 100;
        int num2 = 200;
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        return "greaterNum";
    }

    @GetMapping("/looping")
    public String loop(Model model){
        List<Integer> list = List.of(11,22,33,44);
        model.addAttribute("list",list);
        return "looping";
    }

}

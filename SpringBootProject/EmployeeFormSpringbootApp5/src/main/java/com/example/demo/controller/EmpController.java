package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/")
    public String showEmployeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employee-form";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(@Valid
            @ModelAttribute Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "employee-form";
        }
        empService.save(employee);
        return "redirect:/employees";//It is redirecting to "Controller employees".
    }

    @GetMapping("/employees")
    public String showEmployees(Model model){
        model.addAttribute("employees",empService.getAllEmployees());
        return "employees";//employees is the HTML page which show all list of the employees.
    }

}

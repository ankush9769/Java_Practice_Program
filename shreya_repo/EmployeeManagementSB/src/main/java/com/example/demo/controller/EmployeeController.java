package com.example.demo.controller;


import com.example.demo.entities.Employees;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService=employeeService;
    }



    @GetMapping("/showEmployees")
    public String showEmployeeList(@RequestParam(name = "keyword", required = false)
                                   String keyword,
                                   Model model){
        model.addAttribute("employees",employeeService.searchEmployees(keyword));
        model.addAttribute("keyword", keyword);
        return "employees/employee-list";
    }

    @GetMapping("/new")
    public String showAddEmployeeForm(Model model){
        Employees employees = new Employees();
        employees.setActive(true);
        model.addAttribute("employee",employees);
        model.addAttribute("pageTitle", "AddEmployee");
        model.addAttribute( "formAction", "/employees/save");
       return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute Employees employee, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){

        if (employee.getEmail()!= null && employeeService.emailExists(employee.getEmail())){
            bindingResult.rejectValue("email","duplicate.employee.email","An employee with this email already exists");

        }

        if (bindingResult.hasErrors()){
            model.addAttribute("pageTitle","Add Employee");
            model.addAttribute("formAction","/employees/save");
        }
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("successMessage","Employee Added Successfully");

        return "redirect:/employees";
    }

    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable Long id, Model model){

        Employees employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);

        return "employees/employee-view";
    }

    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model){
        Employees employees = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employees);
        model.addAttribute("pageTitle", "Edit Employee");
        model.addAttribute("formAction","/employees/update/" + id);
        return "employees/employee-form";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @Valid @ModelAttribute Employees employees,
                                 BindingResult bindingResult, Model model,
                                 RedirectAttributes redirectAttributes){

        // while editing we can give existing email id
        if (employees.getEmail() != null  && employeeService.emailExistsForAnotherEmployee(employees.getEmail(),id)){
            bindingResult.rejectValue("email","duplicate.employee.email", "Another employee already uses this email");
        }
        if (bindingResult.hasErrors()){
            employees.setId(id);
            model.addAttribute("pageTitle","Edit Employee");
            model.addAttribute("formAction","/employees/update/"+id);
            return "employees/employee-form";
        }
        employeeService.updateEmployee(id , employees);

        redirectAttributes.addFlashAttribute("successMessage", "Employee Added Successfully");
        return "redirect:/employees";
    }

    @PostMapping("/delete/{id}")

    public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes){
        employeeService.deleteEmployee(id);
        redirectAttributes.addFlashAttribute("successMessage", "Employee Deleted Successfully");
        return "redirect:/employees";
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException exception, Model model){
        model.addAttribute("errorMessage",exception.getMessage());
        return "error/404";
    }

}

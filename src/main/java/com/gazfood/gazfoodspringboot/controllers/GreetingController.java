package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String main(Model model) {
        int employeesCount = employeeService.count();
        model.addAttribute("employeeCount", employeesCount);
        return "index";
    }

    @GetMapping("/restapi")
    public String restapi() {
        return "restapi";
    }

}

package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.CassaService;
import com.gazfood.gazfoodspringboot.service.ContractService;
import com.gazfood.gazfoodspringboot.service.EmployeeService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
public class GreetingController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CassaService cassaService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String main(Model model, Principal principal) {
        model.addAttribute("employeeCount", employeeService.getCountEmployees());
        model.addAttribute("cassaCount", cassaService.getCountCasses());
        model.addAttribute("firstTenContracts", contractService.getFirstTenContracts());

        LocalDate todaydate = LocalDate.now();

        model.addAttribute("allBirthdaysInMonth", employeeService.findAllBirthday(todaydate.getMonthValue()));

        User user = userService.findByUsername(principal.getName());
        System.out.println("Hello " + user.getUsername() + " " + user.getEmail());
        model.addAttribute("user", user);
        return "index";
    }


    @GetMapping("/restapi")
    public String restapi() {
        return "restapi";
    }

}

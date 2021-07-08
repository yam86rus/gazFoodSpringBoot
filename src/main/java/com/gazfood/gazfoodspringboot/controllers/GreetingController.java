package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.*;
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

    @Autowired
    private OrdersService ordersService;

    @GetMapping("")
    public String main(Model model, Principal principal) {
        model.addAttribute("employeeCount", employeeService.getCountEmployees());
        model.addAttribute("cassaCount", cassaService.getCountCasses());
        model.addAttribute("usersCount", userService.getCountUsers());
        model.addAttribute("orderCount", ordersService.getCountOrders());
        model.addAttribute("firstTenContracts", contractService.getFirstTenContracts());

        LocalDate todaydate = LocalDate.now();

        model.addAttribute("allBirthdaysInMonth", employeeService.findAllBirthday(todaydate.getMonthValue()));

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "index";
    }


    @GetMapping("/restapi")
    public String restapi(Model model,Principal principal) {

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "restapi";
    }

}

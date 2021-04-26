package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.service.CassaService;
import com.gazfood.gazfoodspringboot.service.ContractService;
import com.gazfood.gazfoodspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CassaService cassaService;

    @Autowired
    private ContractService contractService;

    @GetMapping("")
    public String main(Model model) {
        model.addAttribute("employeeCount", employeeService.getCountEmployees());
        model.addAttribute("cassaCount",cassaService.getCountCasses());
        model.addAttribute("firstTenContracts",contractService.getFirstTenContracts());
        return "index";
    }

    @GetMapping("/restapi")
    public String restapi() {
        return "restapi";
    }

}

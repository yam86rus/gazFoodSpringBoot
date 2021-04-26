package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DirectoryController {
    @Autowired
    private CityService cityService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private CassaService cassaService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/directories")
    public String getAllDirectories(Model model) {
        model.addAttribute("cityCount",cityService.getCountCities());
        model.addAttribute("employeeCount",employeeService.getCountEmployees());
        model.addAttribute("vacancyCount",vacancyService.getCountVacancies());
        model.addAttribute("cassaCount",cassaService.getCountCasses());
        model.addAttribute("partnerCount",partnerService.getCountPartners());
        model.addAttribute("statusCount",statusService.getCountStatuses());
        model.addAttribute("contractCount",contractService.getCountContracts());
        return "all-directories";
    }
}

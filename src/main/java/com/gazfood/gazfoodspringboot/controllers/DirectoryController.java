package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.service.CityService;
import com.gazfood.gazfoodspringboot.service.EmployeeService;
import com.gazfood.gazfoodspringboot.service.VacancyService;
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

    @GetMapping("/directories")
    public String getAllDirectories(Model model) {
        model.addAttribute("cityCount",cityService.getAllCities().size());
        model.addAttribute("employeeCount",employeeService.getAllEmployees().size());
        model.addAttribute("vacancyCount",vacancyService.getAllVacancies().size());
        return "all-directories";
    }
}

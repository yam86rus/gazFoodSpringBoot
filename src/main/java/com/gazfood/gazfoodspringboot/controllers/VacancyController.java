package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.City;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.entity.Vacancy;
import com.gazfood.gazfoodspringboot.service.CityService;
import com.gazfood.gazfoodspringboot.service.UserService;
import com.gazfood.gazfoodspringboot.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;


    @RequestMapping("/vacancies")
    public String showAllVacancies (Model model, Principal principal) {
        List<Vacancy> allVacancies = vacancyService.getAllVacancies();
        model.addAttribute("allVacancies", allVacancies);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-vacancies";
    }


    @RequestMapping("/addNewVacancy")
    public String addNewVacancy(Model model,Principal principal) {
        Vacancy vacancy = new Vacancy();
        model.addAttribute("vacancy", vacancy);

        List<City> listCities = cityService.getAllCities();
        model.addAttribute("listCities",listCities);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "vacancy-form";
    }

    @RequestMapping("/saveVacancy")
    public String saveVacancy(@ModelAttribute("vacancy") Vacancy vacancy) {
        vacancyService.saveVacancy(vacancy);
        return "redirect:vacancies";
    }

    @RequestMapping("/updateVacancy")
    public String updateVacancy(@RequestParam("vacancyId") int id, Model model,Principal principal) {
        Vacancy vacancy = vacancyService.getVacancy(id);
        model.addAttribute("vacancy", vacancy);

        List<City> listCities = cityService.getAllCities();
        model.addAttribute("listCities",listCities);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "vacancy-form";
    }

    @RequestMapping("/deleteVacancy")
    public String deleteVacancy(@RequestParam("vacancyId") int id) {
        vacancyService.deleteVacancy(id);
        return "redirect:vacancies";
    }

    @RequestMapping("/detailsVacancy")
    public String detailsVacancy(@RequestParam("vacancyId") int id, Model model,Principal principal) {
        Vacancy vacancy = vacancyService.getVacancy(id);
        model.addAttribute("vacancy", vacancy);
        List<City> listCities = cityService.getAllCities();
        model.addAttribute("listCities",listCities);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "vacancy-form";
    }
}

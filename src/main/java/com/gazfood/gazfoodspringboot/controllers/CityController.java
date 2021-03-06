package com.gazfood.gazfoodspringboot.controllers;


import com.gazfood.gazfoodspringboot.entity.City;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.CityService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    @GetMapping("/cities")
    public String showCityPage(Model model, Principal principal) {
        List<City> allCities = cityService.getAllCities();
        model.addAttribute("allCities", allCities);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "all-cities";
    }

    @RequestMapping("/addNewCity")
    public String addNewCity(Model model, Principal principal) {
        City city = new City();
        model.addAttribute("city", city);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "city-form";

    }

    @RequestMapping("/saveCity")
    public String saveCity(@ModelAttribute("city") City city) {
        cityService.saveCity(city);
        return "redirect:cities";
    }

    @RequestMapping(value = "/updateCity")
    public String updateEmployee(@RequestParam("cityId") int id, Model model,Principal principal) {
        City city = cityService.getCity(id);
        model.addAttribute("city", city);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "city-form";
    }

    @RequestMapping("/deleteCity")
    public String deleteCity(@RequestParam("cityId") int id) {
        cityService.deleteCity(id);
        return "redirect:cities";
    }
}

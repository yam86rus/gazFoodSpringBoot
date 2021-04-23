package com.gazfood.gazfoodspringboot.controllers.rest;

import com.gazfood.gazfoodspringboot.entity.City;
import com.gazfood.gazfoodspringboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> showAllCities(){
        List<City> allCities = cityService.getAllCities();
        return allCities;
    }

    @GetMapping("/cities/{id}")
    public City getCity(@PathVariable int id) {
        City city = cityService.getCity(id);
        return city;
    }

}

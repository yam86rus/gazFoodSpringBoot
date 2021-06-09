package com.gazfood.gazfoodspringboot.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gazfood.gazfoodspringboot.entity.Cafeteria;
import com.gazfood.gazfoodspringboot.service.CafeteriaService;
import com.gazfood.gazfoodspringboot.toFront.ToFrontDishes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CafeteriasController {

    @Autowired
    private CafeteriaService cafeteriaService;

    @GetMapping("/cafeterias")
    public List<Cafeteria> getAllCafdeterias (){
        List<Cafeteria> allCafeterias = cafeteriaService.getAllCafeterias().stream().filter(e->e.isActive()==true).collect(Collectors.toList());
        return allCafeterias;
    }

    @GetMapping("/trololo/{id}")
    public String getAllDeps(@PathVariable int id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ToFrontDishes> list  = cafeteriaService.getAllDishes(id);
        return objectMapper.writeValueAsString(list);
    }

}

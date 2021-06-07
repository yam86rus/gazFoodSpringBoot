package com.gazfood.gazfoodspringboot.controllers.rest;

import com.gazfood.gazfoodspringboot.entity.Cafeteria;
import com.gazfood.gazfoodspringboot.service.CafeteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

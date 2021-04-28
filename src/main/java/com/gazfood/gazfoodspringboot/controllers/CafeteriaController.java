package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Cafeteria;
import com.gazfood.gazfoodspringboot.service.CafeteriaService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CafeteriaController {

    @Autowired
    private CafeteriaService cafeteriaService;

    @RequestMapping("/cafeterias")
    public String showAllCafeterias(Model model) {
        List<Cafeteria> allCafeterias = cafeteriaService.getAllCafeterias();
        model.addAttribute("allCafeterias", allCafeterias);
        return "all-cafeterias";
    }

    @RequestMapping("/deleteCafeteria")
    public String deleteCafeteria(@RequestParam("cafeteriaId") int id) {
        cafeteriaService.deleteCafeteria(id);
        return "redirect:cafeterias";
    }

    @RequestMapping("/updateCafeteria")
    public String updateCafeteria(@RequestParam("cafeteriaId") int id, Model model) {
        Cafeteria cafeteria = cafeteriaService.getCafeteria(id);
        model.addAttribute("cafeteria", cafeteria);
        return "cafeteria-form";
    }

    @RequestMapping("/addNewCafeteria")
    public String addNewCafeteria(Model model) {
        Cafeteria cafeteria = new Cafeteria();
        model.addAttribute("cafeteria", cafeteria);
        return "cafeteria-form";
    }

    @RequestMapping("/saveCafeteria")
    public String saveCafeteria(@ModelAttribute("cafeteria") Cafeteria cafeteria) {
        cafeteriaService.saveCafeteria(cafeteria);
        return "redirect:cafeterias";
    }

}

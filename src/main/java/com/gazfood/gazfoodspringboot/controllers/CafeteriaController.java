package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Cafeteria;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.CafeteriaService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class CafeteriaController {

    @Autowired
    private CafeteriaService cafeteriaService;

    @Autowired
    private UserService userService;

    @RequestMapping("/cafeterias")
    public String showAllCafeterias(Model model, Principal principal) {
        List<Cafeteria> allCafeterias = cafeteriaService.getAllCafeterias();
        model.addAttribute("allCafeterias", allCafeterias);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "all-cafeterias";
    }

    @RequestMapping("/deleteCafeteria")
    public String deleteCafeteria(@RequestParam("cafeteriaId") int id) {
        cafeteriaService.deleteCafeteria(id);
        return "redirect:cafeterias";
    }

    @RequestMapping("/updateCafeteria")
    public String updateCafeteria(@RequestParam("cafeteriaId") int id, Model model, Principal principal) {
        Cafeteria cafeteria = cafeteriaService.getCafeteria(id);
        model.addAttribute("cafeteria", cafeteria);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "cafeteria-form";
    }

    @RequestMapping("/addNewCafeteria")
    public String addNewCafeteria(Model model, Principal principal) {
        Cafeteria cafeteria = new Cafeteria();
        model.addAttribute("cafeteria", cafeteria);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "cafeteria-form";
    }

    @RequestMapping("/saveCafeteria")
    public String saveCafeteria(@ModelAttribute("cafeteria") Cafeteria cafeteria) {
        cafeteriaService.saveCafeteria(cafeteria);
        return "redirect:cafeterias";
    }

}

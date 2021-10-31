package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Unit;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.UnitService;

import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UnitController {
    @Autowired
    private UnitService unitService;

    @Autowired
    private UserService userService;

    @RequestMapping("units")
    public String getAllUnits(Model model, Principal principal){
        List<Unit> allUnits = unitService.getAllUnits();
        model.addAttribute("allUnits",allUnits);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-units";
    }
}

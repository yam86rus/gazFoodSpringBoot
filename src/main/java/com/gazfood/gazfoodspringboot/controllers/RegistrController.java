package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.RegisterDish;
import com.gazfood.gazfoodspringboot.service.RegisterDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RegistrController {
    @Autowired
    private RegisterDishService registerDishService;

    @RequestMapping("/registers")
    public String showAllRegisters(Model model) {
        List<RegisterDish> allRegistersDish = registerDishService.getAllRegistersDishOrder();
        model.addAttribute("allRegistersDish", allRegistersDish);
        return "all-registers";
    }
}

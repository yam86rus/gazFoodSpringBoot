package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {


    @Autowired
    private DishService dishService;

    @GetMapping("/menu")
    public String getAllMenus(Model model) {
        model.addAttribute("dishCount", dishService.getCountDishes());
        return "all-menus";
    }
}

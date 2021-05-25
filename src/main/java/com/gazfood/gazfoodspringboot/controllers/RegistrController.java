package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Cassa;
import com.gazfood.gazfoodspringboot.entity.Dish;
import com.gazfood.gazfoodspringboot.entity.Partner;
import com.gazfood.gazfoodspringboot.entity.RegisterDish;
import com.gazfood.gazfoodspringboot.service.DishService;
import com.gazfood.gazfoodspringboot.service.RegisterDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RegistrController {
    @Autowired
    private RegisterDishService registerDishService;

    @Autowired
    private DishService dishService;


    @RequestMapping("/registers")
    public String showAllRegisters(Model model) {
        model.addAttribute("registerDishesCount", registerDishService.getCountRegistersDish());
        return "all-registers";
    }

    @RequestMapping("/registersDishes")
    public String showAllDishesRegister(Model model) {
        List<RegisterDish> allRegistersDish = registerDishService.getAllRegistersDishOrder();
        model.addAttribute("allRegistersDish", allRegistersDish);
        return "all-registerDish";
    }

    @RequestMapping("/addNewRegistersDishes")
    public String addNewRegisterDishes(Model model) {
        List<Dish> allDishes = dishService.getAllDishes();
        RegisterDish registerDish = new RegisterDish();
        model.addAttribute("registerDish", registerDish);
        model.addAttribute("allDishes", allDishes);
        return "registersDish-form";
    }

    @RequestMapping("/saveRegistersDish")
    public String saveRegisterDish(RegisterDish registerDish) {
        registerDishService.saveRegisterDish(registerDish);
        return "redirect:registersDishes";
    }


}

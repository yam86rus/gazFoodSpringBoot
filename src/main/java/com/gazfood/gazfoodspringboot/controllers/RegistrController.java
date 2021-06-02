package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.*;
import com.gazfood.gazfoodspringboot.service.DishService;
import com.gazfood.gazfoodspringboot.service.OrdersService;
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

    @Autowired
    private OrdersService ordersService;


    @RequestMapping("/registers")
    public String showAllRegisters(Model model) {
        model.addAttribute("registerDishesCount", registerDishService.getCountRegistersDish());
        model.addAttribute("registerOrdersCount", ordersService.getCountOrders());

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

    @RequestMapping("/registersOrders")
    public String showAllOrdersRegister(Model model) {
        List<Orders> allRegistersOrder = ordersService.getAllOrders();
        model.addAttribute("allRegistersOrder", allRegistersOrder);
        return "all-registerOrder";
    }


}

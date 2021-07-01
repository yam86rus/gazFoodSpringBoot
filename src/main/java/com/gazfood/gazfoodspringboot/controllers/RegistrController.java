package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.*;
import com.gazfood.gazfoodspringboot.service.DishService;
import com.gazfood.gazfoodspringboot.service.OrdersService;
import com.gazfood.gazfoodspringboot.service.RegisterDishService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class RegistrController {
    @Autowired
    private RegisterDishService registerDishService;

    @Autowired
    private DishService dishService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;


    @RequestMapping("/registers")
    public String showAllRegisters(Model model, Principal principal) {
        model.addAttribute("registerDishesCount", registerDishService.getCountRegistersDish());
        model.addAttribute("registerOrdersCount", ordersService.getCountOrders());

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-registers";
    }

    @RequestMapping("/registersDishes")
    public String showAllDishesRegister(Model model,Principal principal) {
        List<RegisterDish> allRegistersDish = registerDishService.getAllRegistersDishOrder();
        model.addAttribute("allRegistersDish", allRegistersDish);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-registerDish";
    }

    @RequestMapping("/addNewRegistersDishes")
    public String addNewRegisterDishes(Model model,Principal principal) {
        List<Dish> allDishes = dishService.getAllDishes();
        RegisterDish registerDish = new RegisterDish();
        model.addAttribute("registerDish", registerDish);
        model.addAttribute("allDishes", allDishes);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "registersDish-form";
    }

    @RequestMapping("/saveRegistersDish")
    public String saveRegisterDish(RegisterDish registerDish) {
        registerDishService.saveRegisterDish(registerDish);
        return "redirect:registersDishes";
    }

    @RequestMapping("/registersOrders")
    public String showAllOrdersRegister(Model model,Principal principal) {
        List<Orders> allRegistersOrder = ordersService.getAllOrders();
        model.addAttribute("allRegistersOrder", allRegistersOrder);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-registerOrder";
    }

    @RequestMapping("/registersOrders/{id}")
    public String showOrderById(@PathVariable int id, Model model,Principal principal) {
        List<Orders> allRegistersOrder = ordersService.findAllByOrdersListId(id);
        model.addAttribute("allRegistersOrder", allRegistersOrder);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-registerOrder";
    }

}

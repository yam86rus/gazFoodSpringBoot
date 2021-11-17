package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Dish;
import com.gazfood.gazfoodspringboot.entity.DishCategory;
import com.gazfood.gazfoodspringboot.entity.RegisterDish;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.DishCategoryService;
import com.gazfood.gazfoodspringboot.service.DishService;
import com.gazfood.gazfoodspringboot.service.RegisterDishService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class DishController {
    @Value("${upload.path}")
    private String uploadPath;

    @Value("${dishes.path}")
    private String dishesPath;

    @Value("${avatars.path}")
    private String avatarsPath;

    @Value("${cafeterias.path}")
    private String cafeteriasPath;

    @Autowired
    private DishService dishService;

    @Autowired
    private DishCategoryService dishCategoryService;

    @Autowired
    private RegisterDishService registerDishService;

    @Autowired
    private UserService userService;

    @RequestMapping("/dishes")
    public String showAllDishes(Model model, Principal principal) {
        List<Dish> allDishes = dishService.getAllDishes();
        model.addAttribute("allDishes", allDishes);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-dishes";
    }

    @RequestMapping("/addNewDish")
    public String addNewDish(Model model,Principal principal) {
        Dish dish = new Dish();
        model.addAttribute("dish", dish);

        List<DishCategory> listDishCategories = dishCategoryService.getAllDishCategories();
        model.addAttribute("listDishCategories", listDishCategories);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "dish-form";
    }

    @RequestMapping("/saveDish")
    public String saveDish(Dish dish) {
        dishService.saveDish(dish);

        // создаю запись в регистре свденений "Блюда"
        // RegisterDish registerDish = new RegisterDish(LocalDate.now(), 666, dish);
        // registerDishService.saveRegisterDish(registerDish);

        return "redirect:dishes";
    }

    @RequestMapping("/updateDish")
    public String updateDish(@RequestParam("dishId") int id, Model model,Principal principal) {
        Dish dish = dishService.getDish(id);
        model.addAttribute("dish", dish);

        List<DishCategory> listDishCategories = dishCategoryService.getAllDishCategories();
        model.addAttribute("listDishCategories", listDishCategories);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "dish-form";
    }

    @RequestMapping("/deleteDish")
    public String deleteDish(@RequestParam("dishId") int id) {
        dishService.deleteDish(id);
        return "redirect:dishes";
    }
}

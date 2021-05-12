package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Dish;
import com.gazfood.gazfoodspringboot.entity.DishCategory;
import com.gazfood.gazfoodspringboot.service.DishCategoryService;
import com.gazfood.gazfoodspringboot.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private DishCategoryService dishCategoryService;

    @RequestMapping("/dishes")
    public String showAllDishes(Model model) {
        List<Dish> allDishes = dishService.getAllDishes();

        model.addAttribute("allDishes", allDishes);
        return "all-dishes";
    }

    @RequestMapping("/addNewDish")
    public String addNewDish(Model model) {
        Dish dish = new Dish();
        model.addAttribute("dish", dish);

        List<DishCategory> listDishCategories = dishCategoryService.getAllDishCategories();
        model.addAttribute("listDishCategories",listDishCategories);
        return "dish-form";
    }

    @RequestMapping("/saveDish")
    public String saveDish(Dish dish) {
        dishService.saveDish(dish);
        return "redirect:dishes";
    }

    @RequestMapping("/updateDish")
    public String updateDish(@RequestParam("dishId") int id, Model model) {
        Dish dish = dishService.getDish(id);
        model.addAttribute("dish", dish);
        List<DishCategory> listDishCategories = dishCategoryService.getAllDishCategories();
        model.addAttribute("listDishCategories",listDishCategories);
        return "dish-form";
    }

    @RequestMapping("/deleteDish")
    public String deleteDish(@RequestParam("dishId") int id) {
        dishService.deleteDish(id);
        return "redirect:dishes";
    }
}

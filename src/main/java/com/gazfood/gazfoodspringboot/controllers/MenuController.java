package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.service.DishCategoryService;
import com.gazfood.gazfoodspringboot.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {


    @Autowired
    private DishService dishService;

    @Autowired
    private DishCategoryService dishCategoryService;

    @GetMapping("/menu")
    public String getAllMenus(Model model) {
        model.addAttribute("dishCount", dishService.getCountDishes());
        model.addAttribute("dishCategoriesCount", dishCategoryService.getCountDishCategories());
        return "all-menus";
    }
}

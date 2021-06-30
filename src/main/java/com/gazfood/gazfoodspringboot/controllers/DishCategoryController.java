package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.DishCategory;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.DishCategoryService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class DishCategoryController {

    @Autowired
    private DishCategoryService dishCategoryService;

    @Autowired
    private UserService userService;

    @RequestMapping("/dishCategories")
    public String showAllDishCategories(Model model, Principal principal) {
        List<DishCategory> allDishCategories = dishCategoryService.getAllDishCategories();
        model.addAttribute("allDishCategories",allDishCategories);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "all-dishCategories";
    }

    @RequestMapping("/addNewDishCategory")
    public String addNewDishCategory(Model model, Principal principal) {
        DishCategory dishCategory = new DishCategory();
        model.addAttribute("dishCategory", dishCategory);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "dishCategory-form";
    }

    @RequestMapping("saveDishCategory")
    public String saveDishCategory(@ModelAttribute("dishCategory") DishCategory dishCategory) {
       dishCategoryService.saveDishCategory(dishCategory);
        return "redirect:dishCategories";
    }

    @RequestMapping("updateDishCategory")
    public String updateDishCategories(@RequestParam("dishCategoryId") int id, Model model, Principal principal) {
        DishCategory dishCategory = dishCategoryService.getDishCategory(id);
        model.addAttribute("dishCategory",dishCategory);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "dishCategory-form";
    }

    @RequestMapping("deleteDishCategory")
    public String deleteDishCategory(@RequestParam("dishCategoryId") int id) {
        dishCategoryService.deleteDishCategory(id);
        return "redirect:dishCategories";
    }

}

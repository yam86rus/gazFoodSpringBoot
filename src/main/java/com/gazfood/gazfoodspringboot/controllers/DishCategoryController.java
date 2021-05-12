package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.DishCategory;
import com.gazfood.gazfoodspringboot.service.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DishCategoryController {

    @Autowired
    private DishCategoryService dishCategoryService;

    @RequestMapping("/dishCategories")
    public String showAllDishCategories(Model model) {
        List<DishCategory> allDishCategories = dishCategoryService.getAllDishCategories();
        model.addAttribute("allDishCategories",allDishCategories);
        return "all-dishCategories";
    }

    @RequestMapping("/addNewDishCategory")
    public String addNewDishCategory(Model model) {
        DishCategory dishCategory = new DishCategory();
        model.addAttribute("dishCategory", dishCategory);
        return "dishCategory-form";
    }

    @RequestMapping("saveDishCategory")
    public String saveDishCategory(@ModelAttribute("dishCategory") DishCategory dishCategory) {
       dishCategoryService.saveDishCategory(dishCategory);
        return "redirect:dishCategories";
    }

    @RequestMapping("updateDishCategory")
    public String updateDishCategories(@RequestParam("dishCategoryId") int id, Model model) {
        DishCategory dishCategory = dishCategoryService.getDishCategory(id);
        model.addAttribute("dishCategory",dishCategory);
        return "dishCategory-form";
    }

    @RequestMapping("deleteDishCategory")
    public String deleteDishCategory(@RequestParam("dishCategoryId") int id) {
        dishCategoryService.deleteDishCategory(id);
        return "redirect:dishCategories";
    }

}

package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.service.DishCategoryService;
import com.gazfood.gazfoodspringboot.service.DishService;
import com.gazfood.gazfoodspringboot.service.MenuListService;
import com.gazfood.gazfoodspringboot.service.PriceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {


    @Autowired
    private DishService dishService;

    @Autowired
    private DishCategoryService dishCategoryService;

    @Autowired
    private PriceCategoryService priceCategoryService;

    @Autowired
    private MenuListService menuListService;


    @RequestMapping("/menu")
    public String getAllMenus(Model model) {
        model.addAttribute("dishCount", dishService.getCountDishes());
        model.addAttribute("dishCategoriesCount", dishCategoryService.getCountDishCategories());
        model.addAttribute("priceCategoryCount", priceCategoryService.getCountPriceCategories());
        model.addAttribute("menuListCount", menuListService.getCountMenuList());
        return "all-menus";
    }




}

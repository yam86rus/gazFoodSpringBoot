package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuDirectoriesController {


    @Autowired
    private DishService dishService;

    @Autowired
    private DishCategoryService dishCategoryService;

    @Autowired
    private PriceCategoryService priceCategoryService;

    @Autowired
    private MenuListService menuListService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private CafeteriaAndMenuService cafeteriaAndMenuService;


    @RequestMapping("/menuDirectories")
    public String getAllMenus(Model model) {
        model.addAttribute("dishCount", dishService.getCountDishes());
        model.addAttribute("dishCategoriesCount", dishCategoryService.getCountDishCategories());
        model.addAttribute("priceCategoryCount", priceCategoryService.getCountPriceCategories());
        model.addAttribute("menuListCount", menuListService.getCountMenuList());
        model.addAttribute("menuCount", menuService.getCountMenus());
        model.addAttribute("cafeteriaAndMenuCount", cafeteriaAndMenuService.getCountCafeteriaAndMenu());

        return "all-menusDirectories";
    }




}

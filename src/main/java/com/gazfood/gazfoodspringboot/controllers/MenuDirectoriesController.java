package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private CafeteriaService cafeteriaService;


    @RequestMapping("/menuDirectories")
    public String getAllMenus(Model model, Principal principal) {
        model.addAttribute("dishCount", dishService.getCountDishes());
        model.addAttribute("dishCategoriesCount", dishCategoryService.getCountDishCategories());
        model.addAttribute("cafeteriaCount", cafeteriaService.getCountCafeterias());
        model.addAttribute("priceCategoryCount", priceCategoryService.getCountPriceCategories());
        model.addAttribute("menuListCount", menuListService.getCountMenuList());
        model.addAttribute("menuCount", menuService.getCountMenus());
        model.addAttribute("cafeteriaAndMenuCount", cafeteriaAndMenuService.getCountCafeteriaAndMenu());
        model.addAttribute("orderStatusCount", orderStatusService.getCountOrderStatus());
        model.addAttribute("orderCount", ordersService.getCountOrders());
        model.addAttribute("user", userService.findByUsername(principal.getName()));

        return "all-menusDirectories";
    }




}

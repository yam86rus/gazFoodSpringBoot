package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Dish;
import com.gazfood.gazfoodspringboot.entity.Menu;
import com.gazfood.gazfoodspringboot.entity.MenuList;
import com.gazfood.gazfoodspringboot.service.DishService;
import com.gazfood.gazfoodspringboot.service.MenuListService;
import com.gazfood.gazfoodspringboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuListService menuListService;

    @Autowired
    private DishService dishService;

    @RequestMapping("/menus")
    public String showAllMenus(Model model) {
        List<Menu> allMenus = menuService.getAllMenus();
        model.addAttribute("allMenus", allMenus);
        return "all-menus";
    }

    @RequestMapping("/addNewMenu")
    public String addNewMenu(Model model) {
        Menu menu = new Menu();
        model.addAttribute("menu", menu);

        List<MenuList> listMenuList = menuListService.getAllMenuLists();
        model.addAttribute("listMenuList", listMenuList);

        List<Dish> listDishes = dishService.getAllDishes();
        model.addAttribute("listDishes", listDishes);

        return "menu-form";
    }

    @RequestMapping("/saveMenu")
    public String saveMenu(Menu menu) {
        menuService.saveMenu(menu);
        return "redirect:menus";
    }


}

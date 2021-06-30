package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Dish;
import com.gazfood.gazfoodspringboot.entity.Menu;
import com.gazfood.gazfoodspringboot.entity.MenuList;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.DishService;
import com.gazfood.gazfoodspringboot.service.MenuListService;
import com.gazfood.gazfoodspringboot.service.MenuService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuListService menuListService;

    @Autowired
    private DishService dishService;

    @Autowired
    private UserService userService;

    @RequestMapping("/menus")
    public String showAllMenus(Model model, Principal principal) {
        List<Menu> allMenus = menuService.getAllMenus();
        model.addAttribute("allMenus", allMenus);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "all-menus";
    }

    @RequestMapping("/addNewMenu")
    public String addNewMenu(Model model,Principal principal) {
        Menu menu = new Menu();
        model.addAttribute("menu", menu);

        List<MenuList> listMenuList = menuListService.getAllMenuLists();
        model.addAttribute("listMenuList", listMenuList);

        List<Dish> listDishes = dishService.getAllDishes();
        model.addAttribute("listDishes", listDishes);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "menu-form";
    }

    @RequestMapping("/saveMenu")
    public String saveMenu(Menu menu) {
        menuService.saveMenu(menu);
        return "redirect:menus";
    }

    @RequestMapping("/updateMenu")
    public String updateMenu(@RequestParam("menuId") int id, Model model,Principal principal){
        Menu menu = menuService.getMenu(id);
        model.addAttribute("menu",menu);

        List<MenuList> listMenuList = menuListService.getAllMenuLists();
        model.addAttribute("listMenuList", listMenuList);

        List<Dish> listDishes = dishService.getAllDishes();
        model.addAttribute("listDishes", listDishes);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "menu-form";
    }

    @RequestMapping("/deleteMenu")
    public String deleteMenu(@RequestParam("menuId") int id){
        menuService.deleteMenu(id);
        return "redirect:menus";
    }







}

package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.MenuList;
import com.gazfood.gazfoodspringboot.entity.PriceCategory;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.MenuListService;
import com.gazfood.gazfoodspringboot.service.PriceCategoryService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class MenuListController {
    @Autowired
    private MenuListService menuListService;

    @Autowired
    private PriceCategoryService priceCategoryService;

    @Autowired
    private UserService userService;

    @RequestMapping("/menuLists")
    public String showAllMenuLists(Model model, Principal principal) {
        model.addAttribute("allMenuList", menuListService.getAllMenuLists());
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "all-menuList";
    }

    @RequestMapping("/addNewMenuList")
    public String addNewMenuList(Model model,Principal principal) {
        List<PriceCategory> listPriceCategory = priceCategoryService.getAllPriceCategories();
        MenuList menuList = new MenuList();
        model.addAttribute("menuList", menuList);
        model.addAttribute("listPriceCategory", listPriceCategory);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "menuList-form";
    }

    @RequestMapping("/saveMenuList")
    public String saveMenuList(@Valid MenuList menuList, BindingResult bindingResult, Model model,Principal principal) {
        if (bindingResult.hasErrors()){
            List<PriceCategory> listPriceCategory = priceCategoryService.getAllPriceCategories();
            model.addAttribute("listPriceCategory", listPriceCategory);

            User user = userService.findByUsername(principal.getName());
            model.addAttribute("user", user);
            return "menuList-form";
        }
        menuListService.saveMenuList(menuList);
        return "redirect:menuLists";
    }

    @RequestMapping("/updateMenuList")
    public String updateMenuList(@RequestParam("menuListId") int id, Model model,Principal principal) {
        MenuList menuList = menuListService.getMenuList(id);
        model.addAttribute("menuList", menuList);

        List<PriceCategory> listPriceCategory = priceCategoryService.getAllPriceCategories();
        model.addAttribute("listPriceCategory", listPriceCategory);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "menuList-form";

    }

    @RequestMapping("/deleteMenuList")
    public String deleteMenuList(@RequestParam("menuListId") int id){
        menuListService.deleteMenuList(id);
        return "redirect:menuLists";
    }

}

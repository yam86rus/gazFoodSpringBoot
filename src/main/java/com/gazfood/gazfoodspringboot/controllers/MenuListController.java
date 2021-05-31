package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.MenuList;
import com.gazfood.gazfoodspringboot.entity.PriceCategory;
import com.gazfood.gazfoodspringboot.service.MenuListService;
import com.gazfood.gazfoodspringboot.service.PriceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MenuListController {
    @Autowired
    private MenuListService menuListService;

    @Autowired
    private PriceCategoryService priceCategoryService;

    @RequestMapping("/menuLists")
    public String showAllMenuLists(Model model) {
        model.addAttribute("allMenuList", menuListService.getAllMenuLists());
        return "all-menuList";
    }

    @RequestMapping("/addNewMenuList")
    public String addNewMenuList(Model model) {
        List<PriceCategory> listPriceCategory = priceCategoryService.getAllPriceCategories();
        MenuList menuList = new MenuList();
        model.addAttribute("menuList", menuList);
        model.addAttribute("listPriceCategory", listPriceCategory);
        return "menuList-form";
    }

    @RequestMapping("/saveMenuList")
    public String saveMenuList(@Valid MenuList menuList, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            List<PriceCategory> listPriceCategory = priceCategoryService.getAllPriceCategories();
            model.addAttribute("listPriceCategory", listPriceCategory);
            return "menuList-form";
        }
        menuListService.saveMenuList(menuList);
        return "redirect:menuLists";
    }

    @RequestMapping("/updateMenuList")
    public String updateMenuList(@RequestParam("menuListId") int id, Model model) {
        MenuList menuList = menuListService.getMenuList(id);
        model.addAttribute("menuList", menuList);

        List<PriceCategory> listPriceCategory = priceCategoryService.getAllPriceCategories();
        model.addAttribute("listPriceCategory", listPriceCategory);
        return "menuList-form";

    }

    @RequestMapping("/deleteMenuList")
    public String deleteMenuList(@RequestParam("menuListId") int id){
        menuListService.deleteMenuList(id);
        return "redirect:menuLists";
    }

}

package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Partner;
import com.gazfood.gazfoodspringboot.entity.PriceCategory;
import com.gazfood.gazfoodspringboot.entity.User;
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


@Controller
public class PriceCategoryController {
    @Autowired
    private PriceCategoryService priceCategoryService;

    @Autowired
    private UserService userService;

    @RequestMapping("/priceCategories")
    public String getAllPriceCategory(Model model, Principal principal) {
        model.addAttribute("allPriceCategories", priceCategoryService.getAllPriceCategories());

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-priceCategories";
    }

    @RequestMapping("/addNewPriceCategory")
    public String addNewPriceCategory(Model model,Principal principal) {
        PriceCategory priceCategory = new PriceCategory();
        model.addAttribute("priceCategory", priceCategory);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "priceCategory-form";
    }

    @RequestMapping("/updatePriceCategory")
    public String updatePartner(@RequestParam("priceCategoryId") int id, Model model,Principal principal) {
        PriceCategory priceCategory = priceCategoryService.getPriceCategory(id);
        model.addAttribute("priceCategory", priceCategory);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "priceCategory-form";
    }

    @RequestMapping("/savePriceCategory")
    public String savePriceCategory(@Valid PriceCategory priceCategory, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "priceCategory-form";
        }
        priceCategoryService.savePriceCategory(priceCategory);
        return "redirect:priceCategories";
    }

    @RequestMapping("/deletePriceCategory")
    public String deletePriceCategory(@RequestParam("priceCategoryId") int id) {
        priceCategoryService.deletePriceCategory(id);
        return "redirect:priceCategories";
    }

}

package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Partner;
import com.gazfood.gazfoodspringboot.entity.PriceCategory;
import com.gazfood.gazfoodspringboot.service.PriceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PriceCategoryController {
    @Autowired
    private PriceCategoryService priceCategoryService;

    @RequestMapping("/priceCategories")
    public String getAllPriceCategory(Model model) {
        model.addAttribute("allPriceCategories", priceCategoryService.getAllPriceCategories());
        return "all-priceCategories";
    }

    @RequestMapping("/addNewPriceCategory")
    public String addNewPriceCategory(Model model) {
        PriceCategory priceCategory = new PriceCategory();
        model.addAttribute("priceCategory", priceCategory);
        return "priceCategory-form";
    }

    @RequestMapping("/updatePriceCategory")
    public String updatePartner(@RequestParam("priceCategoryId") int id, Model model) {
        PriceCategory priceCategory = priceCategoryService.getPriceCategory(id);
        model.addAttribute("priceCategory", priceCategory);
        return "priceCategory-form";
    }

    @RequestMapping("/savePriceCategory")
    public String savePriceCategory(PriceCategory priceCategory) {
        priceCategoryService.savePriceCategory(priceCategory);
        return "redirect:priceCategories";
    }

    @RequestMapping("/deletePriceCategory")
    public String deletePriceCategory(@RequestParam("priceCategoryId") int id) {
        priceCategoryService.deletePriceCategory(id);
        return "redirect:priceCategories";
    }

}

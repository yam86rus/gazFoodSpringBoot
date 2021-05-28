package com.gazfood.gazfoodspringboot.controllers.rest;

import com.gazfood.gazfoodspringboot.entity.PriceCategory;
import com.gazfood.gazfoodspringboot.service.PriceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceCategoryRestController {
    @Autowired
    private PriceCategoryService priceCategoryService;

    @GetMapping("/priceCategories")
    public List<PriceCategory> showAllPriceCategories() {
        List<PriceCategory> allPriceCategories = priceCategoryService.getAllPriceCategories();
        return allPriceCategories;
    }

    @GetMapping("/priceCategories/{id}")
    public PriceCategory getPriceCategory(@PathVariable int id) {
        PriceCategory priceCategory = priceCategoryService.getPriceCategory(id);
        return priceCategory;
    }

    @PostMapping("/priceCategories")
    public PriceCategory addNewPriceCategory(@RequestBody PriceCategory priceCategory) {
        priceCategoryService.savePriceCategory(priceCategory);
        return priceCategory;
    }


}

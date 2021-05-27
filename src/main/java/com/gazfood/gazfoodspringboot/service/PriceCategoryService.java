package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.PriceCategory;

import java.util.List;

public interface PriceCategoryService {
    List<PriceCategory> getAllPriceCategories();

    void savePriceCategory(PriceCategory priceCategory);

    PriceCategory getPriceCategory(int id);

    void deletePriceCategory(int id);

    long getCountPriceCategories();

}

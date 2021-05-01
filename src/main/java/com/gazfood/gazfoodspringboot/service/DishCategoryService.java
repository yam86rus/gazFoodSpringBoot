package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.DishCategory;

import java.util.List;

public interface DishCategoryService {
    List<DishCategory> getAllDishCategories();

    void saveDishCategory(DishCategory dishCategory);

    DishCategory getDishCategory(int id);

    void deleteDishCategory(int id);

    long getCountDishCategories();
}

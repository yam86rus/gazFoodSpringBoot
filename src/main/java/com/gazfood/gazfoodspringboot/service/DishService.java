package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Dish;

import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();

    void saveDish(Dish dish);

    Dish getDish(int id);

    void deleteDish(int id);

    long getCountDishes();

}

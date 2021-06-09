package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Cafeteria;
import com.gazfood.gazfoodspringboot.toFront.ToFrontDishes;

import java.util.List;

public interface CafeteriaService {
    List<Cafeteria> getAllCafeterias();

    void saveCafeteria(Cafeteria cafeteria);

    Cafeteria getCafeteria(int id);

    void deleteCafeteria(int id);

    long getCountCafeterias();

    List<ToFrontDishes> getAllDishes(int id);



}

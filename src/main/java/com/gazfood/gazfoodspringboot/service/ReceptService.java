package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Recept;

import java.util.List;

public interface ReceptService {
    List<Recept> getAllRecept();

    long getCountRecept();

    void saveRecept(Recept recept);

    Recept getRecept(int id);

    void deleteRecept(int id);



}

package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Recept;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ReceptService {
    List<Recept> getAllRecept();

    long getCountRecept();

    void saveRecept(Recept recept);

    Recept getRecept(int id);

    void deleteRecept(int id);

    void checkAct();

    boolean isFileClosed(File file);

    List<Recept> findAllByCode(String recept_code);

    Recept findFirstByCode(String recept_code);



}

package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.CafeteriaAndMenu;

import java.util.List;


public interface CafeteriaAndMenuService {

    List<CafeteriaAndMenu> getAllCafeteriaAndMenu();

    void savaCafeteriaAndMenu(CafeteriaAndMenu cafeteriaAndMenu);

    CafeteriaAndMenu getCafeteriaAndMenu(int id);

    void deleteCafeteriaAndMenu(int id);

    long getCountCafeteriaAndMenu();
}

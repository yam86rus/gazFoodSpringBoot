package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getAllMenus();

    void saveMenu(Menu menu);

    Menu getMenu(int id);

    void deleteMenu(int id);

    long getCountMenus();

}

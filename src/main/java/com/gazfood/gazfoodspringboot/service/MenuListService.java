package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.MenuList;

import java.util.List;

public interface MenuListService {
    List<MenuList> getAllMenuLists();

    void saveMenuList(MenuList menuList);

    MenuList getMenuList(int id);

    void deleteMenuList(int id);

    long getCountMenuList();
}

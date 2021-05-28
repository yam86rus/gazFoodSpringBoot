package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.MenuListRepository;
import com.gazfood.gazfoodspringboot.entity.MenuList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuListServiceImpl implements MenuListService {

    @Autowired
    private MenuListRepository menuListRepository;

    @Override
    public List<MenuList> getAllMenuLists() {
        List<MenuList> allMenuLists = menuListRepository.findAll();
        return allMenuLists;
    }

    @Override
    public void saveMenuList(MenuList menuList) {
        menuListRepository.save(menuList);
    }

    @Override
    public MenuList getMenuList(int id) {
        MenuList menuList = null;
        Optional<MenuList> optional = menuListRepository.findById(id);
        if (optional.isPresent()){
            menuList = optional.get();
        }
        return menuList;
    }

    @Override
    public void deleteMenuList(int id) {
        menuListRepository.deleteById(id);
    }

    @Override
    public long getCountMenuList() {
        return menuListRepository.count();
    }
}

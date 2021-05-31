package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.MenuRepository;
import com.gazfood.gazfoodspringboot.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getAllMenus() {
        List<Menu> allMenu = menuRepository.findAll();
        return allMenu;
    }

    @Override
    public void saveMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public Menu getMenu(int id) {

        Menu menu = null;
        Optional<Menu> optional = menuRepository.findById(id);
        if (optional.isPresent()) {
            menu = optional.get();
        }
        return menu;
    }

    @Override
    public void deleteMenu(int id) {
        menuRepository.deleteById(id);
    }

    @Override
    public long getCountMenus() {
        return menuRepository.count();
    }
}

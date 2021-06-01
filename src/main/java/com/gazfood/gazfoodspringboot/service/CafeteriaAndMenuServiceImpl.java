package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.CafeteriaAndMenuRepository;
import com.gazfood.gazfoodspringboot.entity.CafeteriaAndMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeteriaAndMenuServiceImpl implements CafeteriaAndMenuService {

    @Autowired
    private CafeteriaAndMenuRepository cafeteriaAndMenuRepository;


    @Override
    public List<CafeteriaAndMenu> getAllCafeteriaAndMenu() {
        List<CafeteriaAndMenu> getAllCafeteriaAndMenu = cafeteriaAndMenuRepository.findAll();
        return getAllCafeteriaAndMenu;
    }

    @Override
    public void savaCafeteriaAndMenu(CafeteriaAndMenu cafeteriaAndMenu) {
        cafeteriaAndMenuRepository.save(cafeteriaAndMenu);
    }

    @Override
    public CafeteriaAndMenu getCafeteriaAndMenu(int id) {
        CafeteriaAndMenu cafeteriaAndMenu = null;
        Optional<CafeteriaAndMenu> optional = cafeteriaAndMenuRepository.findById(id);
        if (optional.isPresent()) {
            cafeteriaAndMenu = optional.get();
        }
        return cafeteriaAndMenu;
    }

    @Override
    public void deleteCafeteriaAndMenu(int id) {
        cafeteriaAndMenuRepository.deleteById(id);
    }

    @Override
    public long getCountCafeteriaAndMenu() {
        return cafeteriaAndMenuRepository.count();
    }
}

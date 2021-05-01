package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.DishCategoryRepository;
import com.gazfood.gazfoodspringboot.entity.DishCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishCategoryServiceImpl implements DishCategoryService{

    @Autowired
    private DishCategoryRepository dishCategoryRepository;
    @Override
    public List<DishCategory> getAllDishCategories() {
        return dishCategoryRepository.findAll();
    }

    @Override
    public void saveDishCategory(DishCategory dishCategory) {
        dishCategoryRepository.save(dishCategory);
    }

    @Override
    public DishCategory getDishCategory(int id) {
        DishCategory dishCategory = null;
        Optional<DishCategory> optional = dishCategoryRepository.findById(id);
        if (optional.isPresent()){
            dishCategory = optional.get();
        }
        return dishCategory;
    }

    @Override
    public void deleteDishCategory(int id) {
        dishCategoryRepository.deleteById(id);
    }

    @Override
    public long getCountDishCategories() {
        return dishCategoryRepository.count();
    }
}

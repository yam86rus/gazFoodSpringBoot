package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.DishRepository;
import com.gazfood.gazfoodspringboot.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public void saveDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public Dish getDish(int id) {
        Dish dish = null;
        Optional<Dish> optional = dishRepository.findById(id);
        if (optional.isPresent()) {
            dish = optional.get();
        }
        return dish;
    }

    @Override
    public void deleteDish(int id) {
        dishRepository.deleteById(id);
    }

    @Override
    public long getCountDishes() {
        return dishRepository.count();
    }
}

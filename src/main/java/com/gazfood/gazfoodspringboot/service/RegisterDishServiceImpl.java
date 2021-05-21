package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.RegisterDishRepository;
import com.gazfood.gazfoodspringboot.entity.RegisterDish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterDishServiceImpl implements RegisterDishService{

    @Autowired
    private RegisterDishRepository registerDishRepository;

    @Override
    public List<RegisterDish> getAllRegistersDish() {
        List<RegisterDish> allRegisterDish = registerDishRepository.findAll();
        return allRegisterDish;
    }

    @Override
    public List<RegisterDish> getAllRegistersDishOrder() {
        List<RegisterDish> allRegisterDishOrder = registerDishRepository.findAllByOrderByDishData();
        return allRegisterDishOrder;
    }
}

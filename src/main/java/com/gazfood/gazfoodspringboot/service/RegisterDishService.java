package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Partner;
import com.gazfood.gazfoodspringboot.entity.RegisterDish;

import java.util.List;

public interface RegisterDishService {
    List<RegisterDish> getAllRegistersDish();
    List<RegisterDish> getAllRegistersDishOrder();
    long getCountRegistersDish();
    void saveRegisterDish(RegisterDish registerDish);
}

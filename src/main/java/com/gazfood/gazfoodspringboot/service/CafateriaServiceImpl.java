package com.gazfood.gazfoodspringboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gazfood.gazfoodspringboot.dao.CafeteriaRepository;
import com.gazfood.gazfoodspringboot.entity.Cafeteria;
import com.gazfood.gazfoodspringboot.toFront.ToFrontDishes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CafateriaServiceImpl implements CafeteriaService {

    @Autowired
    private CafeteriaRepository cafeteriaRepository;


    @Override
    public List<Cafeteria> getAllCafeterias() {
        List<Cafeteria> allCafeterias = cafeteriaRepository.findAll();
        return allCafeterias;
    }

    @Override
    public void saveCafeteria(Cafeteria cafeteria) {
        cafeteriaRepository.save(cafeteria);
    }

    @Override
    public Cafeteria getCafeteria(int id) {
        Cafeteria cafeteria = null;
        Optional<Cafeteria> optional = cafeteriaRepository.findById(id);
        if (optional.isPresent()) {
            cafeteria = optional.get();
        }
        return cafeteria;
    }

    @Override
    public void deleteCafeteria(int id) {
        cafeteriaRepository.deleteById(id);
    }

    @Override
    public long getCountCafeterias() {
        return cafeteriaRepository.count();
    }

    @Override
    public List<ToFrontDishes> getAllDishes(int id) {
        List<Object[]> list  = cafeteriaRepository.findAllDishesInMenuInCafeterias(id);
        List<ToFrontDishes> list2 = new ArrayList<>();

        for (Object[] obj: list){
            int i = (int) (convertObjectToList(obj)).get(0);
            String name = (String) (convertObjectToList(obj)).get(1);
            String description = (String) (convertObjectToList(obj)).get(2);
            double price = (double) (convertObjectToList(obj)).get(3);
            String image = (String) (convertObjectToList(obj)).get(4);
            list2.add(new ToFrontDishes(i,name,description,price,image));
        }

        return list2;
    }

    public static List<?> convertObjectToList(Object object) {
        List<?> list = new ArrayList<>();
        if (object.getClass().isArray()) {
            list = Arrays.asList((Object[])object);
        } else if (object instanceof Collection) {
            list = new ArrayList<>((Collection<?>)object);
        }
        return list;
    }


}

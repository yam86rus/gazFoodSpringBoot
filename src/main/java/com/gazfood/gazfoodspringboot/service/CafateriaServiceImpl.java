package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.CafeteriaRepository;
import com.gazfood.gazfoodspringboot.entity.Cafeteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}

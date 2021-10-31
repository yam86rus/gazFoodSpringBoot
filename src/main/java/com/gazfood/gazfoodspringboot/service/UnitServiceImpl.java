package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.UnitsRepository;
import com.gazfood.gazfoodspringboot.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService{

    @Autowired
    private UnitsRepository unitsRepository;


    @Override
    public List<Unit> getAllUnits() {
        return unitsRepository.findAll();
    }

    @Override
    public void saveUnit(Unit unit) {
        unitsRepository.save(unit);
    }

    @Override
    public Unit getUnit(int id) {
        Unit unit = null;

       Optional<Unit> optional=  unitsRepository.findById(id);
       if (optional.isPresent()){
           unit = optional.get();
       }
       return unit;
    }

    @Override
    public void deleteUnit(int id) {
        unitsRepository.deleteById(id);
    }

    @Override
    public long getCountUnits() {
        return unitsRepository.count();
    }
}

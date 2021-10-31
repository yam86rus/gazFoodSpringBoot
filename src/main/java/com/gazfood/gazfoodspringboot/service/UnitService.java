package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Unit;

import java.util.List;

public interface UnitService {
    public List<Unit> getAllUnits();
    public void saveUnit(Unit unit);
    public Unit getUnit(int id);
    public void deleteUnit(int id);
    public long getCountUnits();
}

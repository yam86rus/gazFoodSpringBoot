package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.CityDAO;
import com.gazfood.gazfoodspringboot.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityDAO cityDAO;

    @Override
    @Transactional
    public List<City> getAllCities() {
        return cityDAO.getAllCities();
    }

    @Override
    @Transactional
    public void saveCity(City city) {
        cityDAO.saveCity(city);
    }

    @Override
    @Transactional
    public City getCity(int id) {
        return cityDAO.getCity(id);
    }

    @Override
    @Transactional
    public void deleteCity(int id) {
        cityDAO.deleteCity(id);
    }
}

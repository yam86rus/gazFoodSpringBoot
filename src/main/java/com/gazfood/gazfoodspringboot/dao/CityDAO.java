package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.City;

import java.util.List;

public interface CityDAO {
    List<City> getAllCities();

    void saveCity(City city);

    City getCity(int id);

    void deleteCity(int id);
}

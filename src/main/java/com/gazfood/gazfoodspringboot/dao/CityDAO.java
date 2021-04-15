package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.City;

import java.util.List;

public interface CityDAO {
    List<City> getAllCities();

    public void saveCity(City city);

    public City getCity(int id);

    public void deleteCity(int id);
}

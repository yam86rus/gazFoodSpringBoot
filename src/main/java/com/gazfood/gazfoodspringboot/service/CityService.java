package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.City;

import java.util.List;

public interface CityService {
    public List<City> getAllCities();

    public void saveCity(City city);

    public City getCity(int id);

    public void deleteCity(int id);

    public long getCountCities();
}

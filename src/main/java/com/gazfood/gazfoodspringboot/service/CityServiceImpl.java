package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.CityRepository;
import com.gazfood.gazfoodspringboot.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public City getCity(int id) {
        City city = null;
        Optional<City> optional = cityRepository.findById(id);
        if (optional.isPresent()) {
            city = optional.get();
        }
        return city;
    }

    @Override
    public void deleteCity(int id) {
        cityRepository.deleteById(id);
    }

    @Override
    public long getCountCities() {
        return cityRepository.count();
    }
}

package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}

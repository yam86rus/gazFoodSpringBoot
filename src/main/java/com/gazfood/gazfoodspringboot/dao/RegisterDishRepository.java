package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.RegisterDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterDishRepository extends JpaRepository<RegisterDish, Integer> {
    List<RegisterDish> findAllByOrderByDishData();
}

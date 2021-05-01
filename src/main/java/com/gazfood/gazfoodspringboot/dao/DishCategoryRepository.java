package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Integer> {
}

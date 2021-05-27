package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.PriceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceCategoryRepository extends JpaRepository<PriceCategory, Integer> {
}

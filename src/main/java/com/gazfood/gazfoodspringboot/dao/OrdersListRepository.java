package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.OrdersList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersListRepository extends JpaRepository<OrdersList, Integer> {
}

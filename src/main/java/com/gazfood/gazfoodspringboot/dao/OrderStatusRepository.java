package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}

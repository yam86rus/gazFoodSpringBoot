package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
public List<Orders> findAllByOrdersListId (int id);
}

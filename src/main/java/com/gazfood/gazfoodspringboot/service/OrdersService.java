package com.gazfood.gazfoodspringboot.service;


import com.gazfood.gazfoodspringboot.entity.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> getAllOrders();

    void saveOrders(Orders orders);

    Orders getOrders(int id);

    void deleteOrders(int id);

    long getCountOrders();

}

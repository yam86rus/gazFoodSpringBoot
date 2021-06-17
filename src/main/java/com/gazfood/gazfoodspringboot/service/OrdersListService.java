package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.OrdersList;

import java.util.List;

public interface OrdersListService {
    List<OrdersList> getAllOrdersList();

    void saveOrdersList(OrdersList ordersList);
}

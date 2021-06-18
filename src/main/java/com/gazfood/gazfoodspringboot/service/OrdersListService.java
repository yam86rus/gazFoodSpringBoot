package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Orders;
import com.gazfood.gazfoodspringboot.entity.OrdersList;

import java.util.List;

public interface OrdersListService {
    List<OrdersList> getAllOrdersList();

    void saveOrdersList(OrdersList ordersList);

    OrdersList getOrdersList(int id);

    void deleteOrdersList (int id);

    long getCountOrdersList();

}

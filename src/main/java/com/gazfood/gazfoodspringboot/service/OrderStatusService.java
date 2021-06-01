package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.OrderStatus;

import java.util.List;

public interface OrderStatusService {

    List<OrderStatus> getAllOrderStatuses();

    void saveOrderStatus(OrderStatus orderStatus);

    OrderStatus getOrderStatus(int id);

    void deleteOrderStatus(int id);

    long getCountOrderStatus();

}

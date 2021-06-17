package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.OrdersListRepository;
import com.gazfood.gazfoodspringboot.entity.OrdersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersListServiceImpl implements OrdersListService{
    @Autowired
    private OrdersListRepository ordersListRepository;

    @Override
    public List<OrdersList> getAllOrdersList() {
        List<OrdersList> allOrdersList = ordersListRepository.findAll();
        return allOrdersList;
    }

    @Override
    public void saveOrdersList(OrdersList ordersList) {
        ordersListRepository.save(ordersList);
    }
}

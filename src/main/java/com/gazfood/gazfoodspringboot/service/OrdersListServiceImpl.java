package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.OrdersListRepository;
import com.gazfood.gazfoodspringboot.entity.OrdersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public OrdersList getOrdersList(int id) {
        OrdersList ordersList = null;
        Optional<OrdersList> optional = ordersListRepository.findById(id);
        if(optional.isPresent()){
            ordersList = optional.get();
        }
        return ordersList;
    }

    @Override
    public void deleteOrdersList(int id) {
        ordersListRepository.deleteById(id);
    }

    @Override
    public long getCountOrdersList() {
        return ordersListRepository.count();
    }
}

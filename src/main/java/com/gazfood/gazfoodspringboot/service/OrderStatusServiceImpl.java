package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.OrderStatusRepository;
import com.gazfood.gazfoodspringboot.entity.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public List<OrderStatus> getAllOrderStatuses() {
        List<OrderStatus> allOrderStatus = orderStatusRepository.findAll();
        return allOrderStatus;
    }

    @Override
    public void saveOrderStatus(OrderStatus orderStatus) {
        orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus getOrderStatus(int id) {
        OrderStatus orderStatus = null;
        Optional<OrderStatus> optional = orderStatusRepository.findById(id);
        if (optional.isPresent()) {
            orderStatus = optional.get();
        }
        return orderStatus;
    }

    @Override
    public void deleteOrderStatus(int id) {
        orderStatusRepository.deleteById(id);
    }

    @Override
    public long getCountOrderStatus() {
        return orderStatusRepository.count();
    }
}

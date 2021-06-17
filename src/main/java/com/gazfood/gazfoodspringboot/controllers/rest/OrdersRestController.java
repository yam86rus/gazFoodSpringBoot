package com.gazfood.gazfoodspringboot.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gazfood.gazfoodspringboot.entity.OrderStatus;
import com.gazfood.gazfoodspringboot.entity.Orders;
import com.gazfood.gazfoodspringboot.entity.OrdersList;
import com.gazfood.gazfoodspringboot.service.OrderStatusService;
import com.gazfood.gazfoodspringboot.service.OrdersListService;
import com.gazfood.gazfoodspringboot.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersRestController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersListService ordersListService;

    @Autowired
    private OrderStatusService orderStatusService;

    @PostMapping("/orders")
    public void addNewOrder(@RequestBody String str) {
        double summ = 0.00;
        System.out.println(str);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Orders> list = Arrays.asList(objectMapper.readValue(str.toString(), Orders[].class));
            for (Orders order : list) {
                ordersService.saveOrders(order);
                summ += order.getPrice()*order.getCount();
            }
            ordersListService.saveOrdersList(new OrdersList(2, summ, orderStatusService.getOrderStatus(1), LocalDateTime.now(), null, null));
            System.out.println(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Json получен и выведен в консоль");
    }
}

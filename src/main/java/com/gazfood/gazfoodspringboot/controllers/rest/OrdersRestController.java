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
        System.out.println(str);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Orders> list = Arrays.asList( objectMapper.readValue(str.toString(), Orders[].class) );
            for (Orders order: list){
                ordersService.saveOrders(order);
                System.out.println(order.toString());

                ordersListService.saveOrdersList(new OrdersList.Builder()
                        .withOrderSum(1000)
                        .withOrderData(LocalDateTime.now())
                        .withOrderStatus(new OrderStatus())
                        .build());

            }
            System.out.println(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Json получен и выведен в консоль");
    }
}

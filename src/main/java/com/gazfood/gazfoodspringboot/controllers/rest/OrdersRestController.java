package com.gazfood.gazfoodspringboot.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gazfood.gazfoodspringboot.entity.Orders;
import com.gazfood.gazfoodspringboot.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersRestController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/orders")
    public void addNewOrder(@RequestBody String str) {
        System.out.println(str);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Orders> list = Arrays.asList( objectMapper.readValue(str.toString(), Orders[].class) );
            for (Orders order: list){
                ordersService.saveOrders(order);
            }
            System.out.println(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Json получен и выведен в консоль");
    }
}

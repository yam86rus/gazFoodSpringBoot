package com.gazfood.gazfoodspringboot.controllers.rest;

import com.gazfood.gazfoodspringboot.entity.Orders;
import com.gazfood.gazfoodspringboot.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrdersRestController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/orders")
    public void addNewOrder(@RequestBody String str) {
        System.out.println(str);
//        ordersService.saveOrders(orders);
        System.out.println("Json получен и выведен в консоль");
    }
}

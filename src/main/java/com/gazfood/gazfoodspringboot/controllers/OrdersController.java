package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Orders;
import com.gazfood.gazfoodspringboot.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<Orders> allOrders = ordersService.getAllOrders();
        model.addAttribute("allOrders",allOrders);
        return "all-orders";
    }
}

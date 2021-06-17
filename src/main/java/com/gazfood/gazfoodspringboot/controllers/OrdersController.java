package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.OrdersList;
import com.gazfood.gazfoodspringboot.service.OrdersListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private OrdersListService ordersListService;
    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<OrdersList> allOrders = ordersListService.getAllOrdersList();
        model.addAttribute("allOrders",allOrders);
        return "all-orders";
    }
}

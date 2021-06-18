package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.*;
import com.gazfood.gazfoodspringboot.service.OrderStatusService;
import com.gazfood.gazfoodspringboot.service.OrdersListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private OrdersListService ordersListService;
    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<OrdersList> allOrders = ordersListService.getAllOrdersList();
        model.addAttribute("allOrders", allOrders);
        return "all-orders";
    }

    @RequestMapping("/updateOrdersList")
    public String updateOrdersList(@RequestParam("ordersListId") int id, Model model) {
        OrdersList ordersList = ordersListService.getOrdersList(id);
        model.addAttribute("ordersList", ordersList);

        List<OrderStatus> OrderStatus = orderStatusService.getAllOrderStatuses();
        model.addAttribute("OrderStatus", OrderStatus);
        return "ordersList-form";
    }

    @RequestMapping("/saveOrdersList")
    public String saveOrdersList(OrdersList ordersList) {
        System.out.println("Сохранение объекта OrdersList" + ordersList);
        ordersListService.saveOrdersList(ordersList);
        return "redirect:orders";
    }

    @RequestMapping("/addNewOrdersList")
    public String addNewOrdersList(Model model) {
        OrdersList ordersList = new OrdersList();
        model.addAttribute("ordersList", ordersList);

        List<OrderStatus> OrderStatus = orderStatusService.getAllOrderStatuses();
        model.addAttribute("OrderStatus", OrderStatus);
        return "ordersList-form";
    }
}

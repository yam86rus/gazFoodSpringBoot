package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.*;
import com.gazfood.gazfoodspringboot.service.OrderStatusService;
import com.gazfood.gazfoodspringboot.service.OrdersListService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrdersController {

    @Autowired
    private OrdersListService ordersListService;
    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private UserService userService;

    @GetMapping("/orders")
    public String getAllOrders(Model model, Principal principal) {
        List<OrdersList> allOrders = ordersListService.getAllOrdersList()
                .stream()
                .sorted(Comparator.comparing(OrdersList::getId).reversed()).collect(Collectors.toList());
        model.addAttribute("allOrders", allOrders);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "all-orders";
    }

    @RequestMapping("/updateOrdersList")
    public String updateOrdersList(@RequestParam("ordersListId") int id, Model model,Principal principal) {
        OrdersList ordersList = ordersListService.getOrdersList(id);
        model.addAttribute("ordersList", ordersList);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

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
    public String addNewOrdersList(Model model,Principal principal) {
        OrdersList ordersList = new OrdersList();
        model.addAttribute("ordersList", ordersList);

        List<OrderStatus> OrderStatus = orderStatusService.getAllOrderStatuses();
        model.addAttribute("OrderStatus", OrderStatus);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "ordersList-form";
    }
}

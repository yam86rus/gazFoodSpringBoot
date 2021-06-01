package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.OrderStatus;
import com.gazfood.gazfoodspringboot.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderStatusController {
    @Autowired
    private OrderStatusService orderStatusService;

    @RequestMapping("/orderStatuses")
    public String showAllOrderStatus(Model model) {
        List<OrderStatus> allOrderStatus = orderStatusService.getAllOrderStatuses();
        model.addAttribute("allOrderStatus", allOrderStatus);
        return "all-orderStatuses";
    }

    @RequestMapping("/addNewOrderStatus")
    public String addNewOrderStatus(Model model) {
        OrderStatus orderStatus = new OrderStatus();
        model.addAttribute("orderStatus", orderStatus);
        return "orderStatus-form";
    }

    @RequestMapping("/saveOrderStatus")
    public String saveOrderStatus(@Valid OrderStatus orderStatus, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "orderStatus-form";
        }
        orderStatusService.saveOrderStatus(orderStatus);
        return "redirect:/orderStatuses";
    }

    @RequestMapping("/deleteOrderStatus")
    public String deleteOrderStatus(@RequestParam("orderStatusId") int id) {
        orderStatusService.deleteOrderStatus(id);
        return "redirect:/orderStatuses";
    }

    @RequestMapping("/updateOrderStatus")
    public String updateOrderStatus(@RequestParam("orderStatusId") int id, Model model) {
        OrderStatus orderStatus = orderStatusService.getOrderStatus(id);
        model.addAttribute("orderStatus", orderStatus);
        return "orderStatus-form";
    }
}

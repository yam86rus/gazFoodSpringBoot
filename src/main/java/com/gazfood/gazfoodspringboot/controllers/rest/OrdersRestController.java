package com.gazfood.gazfoodspringboot.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gazfood.gazfoodspringboot.entity.OrderStatus;
import com.gazfood.gazfoodspringboot.entity.Orders;
import com.gazfood.gazfoodspringboot.entity.OrdersList;
import com.gazfood.gazfoodspringboot.service.OrderStatusService;
import com.gazfood.gazfoodspringboot.service.OrdersListService;
import com.gazfood.gazfoodspringboot.service.OrdersService;
import com.gazfood.gazfoodspringboot.service.SendEmailService;
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

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/orders")
    public void addNewOrder(@RequestBody String str) {
        double summ = 0.00;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Orders> list = Arrays.asList(objectMapper.readValue(str.toString(), Orders[].class));
            for (Orders order : list) {
                ordersService.saveOrders(order);
                summ += order.getPrice() * order.getCount();
            }
            OrdersList ordersList = new OrdersList(2,
                    summ,
                    orderStatusService.getOrderStatus(1),
                    LocalDateTime.now(),
                    null,
                    null);

            // Сохраняем заказ в БД
            ordersListService.saveOrdersList(ordersList);

            // Отправляем пиьмо с новым заказом
            sendEmailService.sendEmail("yam_1985@mail.ru",
                    "Получен новый заказ № "
                            .concat(String.valueOf(ordersList.getId()))
                            .concat(" на сумму ")
                            .concat(String.valueOf(summ))
                            .concat(" рублей"),
                    "Новый заказ");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

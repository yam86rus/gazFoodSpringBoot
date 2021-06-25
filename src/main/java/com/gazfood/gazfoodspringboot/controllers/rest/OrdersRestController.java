package com.gazfood.gazfoodspringboot.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gazfood.gazfoodspringboot.entity.Email;
import com.gazfood.gazfoodspringboot.entity.Orders;
import com.gazfood.gazfoodspringboot.entity.OrdersList;
import com.gazfood.gazfoodspringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Autowired
    private EmailService emailService;

    @PostMapping("/orders")
    public int addNewOrder(@RequestBody String str) {

        // Общая сумма заказа в рублях
        double sum = 0.00;
        // Номер заказа
        int orderId = 0;

        // Текст для отправки email
        StringBuilder orderDishes = new StringBuilder();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Получили Json c заказами и распарсили в List<Orders>
            List<Orders> list = Arrays.asList(objectMapper.readValue(str.toString(), Orders[].class));

            // Для entity OrdersList создали новый заказ
            OrdersList ordersList = new OrdersList();

            // Сохраняем заказ в БД
            ordersListService.saveOrdersList(ordersList);

            // Получили id этого заказа для вставки в entity "Orders" во все поля orders_list_id
            orderId = ordersList.getId();

            for (Orders order : list) {
                order.setOrdersListId(orderId);
                ordersService.saveOrders(order);

                // Обновили общую сумму заказа
                sum += order.getPrice() * order.getCount();

                // Дополнили список заказанных товаров и их количество
                orderDishes.append(order.getCafeteriaName())
                        .append(", блюдо: \"")
                        .append(order.getDishesName())
                        .append("\". Количество: ")
                        .append(order.getCount())
                        .append("\n")
                        .append("\n");

            }
            // Заполнили данные для заказа
            ordersList.setOrdersSum(sum);
            ordersList.setOrderStatus(orderStatusService.getOrderStatus(1));
            ordersList.setOrderData(LocalDateTime.now());
            ordersList.setUser(list.get(0).getUser());
            ordersList.setPhoneNumber(list.get(0).getPhone());

            // обновляем данные по заказу
            ordersListService.saveOrdersList(ordersList);


            // Получаем список email`ов из бд для рассылки
            List<String> listEmails = emailService.getAllEmails().stream()
                    .map(object -> Objects.toString(object.getEmail(), null))
                    .collect(Collectors.toList());



            // отправляем пиьмо с новым заказом по списку email`ов
            sendEmailService.sendEmail(listEmails,
                    "Получен новый заказ № "
                            .concat(String.valueOf(ordersList.getId()))
                            .concat(" на сумму: ")
                            .concat(String.valueOf(sum))
                            .concat(" рублей\n")
                            .concat("Заказчик: " + ordersList.getUser())
                            .concat("\n")
                            .concat("Телефон: " + ordersList.getPhoneNumber())
                            .concat("\n")
                            .concat("\n")
                            .concat(orderDishes.toString())
                            .concat("\n"),
                    "Новый заказ");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return orderId;
    }
}

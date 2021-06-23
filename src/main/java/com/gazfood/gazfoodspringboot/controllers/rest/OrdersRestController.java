package com.gazfood.gazfoodspringboot.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gazfood.gazfoodspringboot.entity.Orders;
import com.gazfood.gazfoodspringboot.entity.OrdersList;
import com.gazfood.gazfoodspringboot.service.OrderStatusService;
import com.gazfood.gazfoodspringboot.service.OrdersListService;
import com.gazfood.gazfoodspringboot.service.OrdersService;
import com.gazfood.gazfoodspringboot.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


            // Отправляем пиьмо с новым заказом
//            sendEmailService.sendEmail("yam_1985@mail.ru",
//                    "Получен новый заказ № "
//                            .concat(String.valueOf(ordersList.getId()))
//                            .concat(" на сумму: ")
//                            .concat(String.valueOf(sum))
//                            .concat(" рублей\n")
//                            .concat("Заказчик: " + ordersList.getUser())
//                            .concat("\n")
//                            .concat("Телефон: " + ordersList.getPhoneNumber())
//                            .concat("\n")
//                            .concat("\n")
//                            .concat(orderDishes.toString()),
//                    "Новый заказ");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return orderId;
    }
}

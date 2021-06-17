package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_list")
public class OrdersList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_sum")
    private double ordersSum;

    @ManyToOne
    @JoinColumn(name = "orders_status_id")
    private OrderStatus orderStatus;

    @Column(name = "order_data")
    private LocalDateTime orderData;

    @Column(name = "confirmed_data")
    private LocalDateTime confirmedData;

    @Column(name = "execute_data")
    private LocalDateTime executeData;

    public OrdersList() {
    }

    public OrdersList(int orderId, double ordersSum, OrderStatus orderStatus, LocalDateTime orderData, LocalDateTime confirmedData, LocalDateTime executeData) {
        this.orderId = orderId;
        this.ordersSum = ordersSum;
        this.orderStatus = orderStatus;
        this.orderData = orderData;
        this.confirmedData = confirmedData;
        this.executeData = executeData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getOrdersSum() {
        return ordersSum;
    }

    public void setOrdersSum(double ordersSum) {
        this.ordersSum = ordersSum;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderData() {
        return orderData;
    }

    public void setOrderData(LocalDateTime orderData) {
        this.orderData = orderData;
    }

    public LocalDateTime getConfirmedData() {
        return confirmedData;
    }

    public void setConfirmedData(LocalDateTime confirmedData) {
        this.confirmedData = confirmedData;
    }

    public LocalDateTime getExecuteData() {
        return executeData;
    }

    public void setExecuteData(LocalDateTime executeData) {
        this.executeData = executeData;
    }

    public static class Builder {
        private OrdersList ordersList;

        public Builder() {
            ordersList = new OrdersList();
        }

        public Builder withOrderId(int orderId) {
            ordersList.orderId = orderId;
            return this;
        }

        public Builder withOrderSum(double orderSum) {
            ordersList.ordersSum = orderSum;
            return this;
        }

        public Builder withOrderStatus(OrderStatus orderStatus) {
            ordersList.orderStatus = orderStatus;
            return this;
        }

        public Builder withOrderData(LocalDateTime orderData) {
            ordersList.orderData = orderData;
            return this;
        }
        public Builder withOrderConfirmData(LocalDateTime confirmData) {
            ordersList.confirmedData = confirmData;
            return this;
        }
        public Builder withOrderExecuteData(LocalDateTime executeData) {
            ordersList.executeData = executeData;
            return this;
        }

        public OrdersList build(){
            return new OrdersList();
        }

    }
}

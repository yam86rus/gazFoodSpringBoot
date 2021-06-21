package com.gazfood.gazfoodspringboot.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_list")
public class OrdersList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_sum")
    private double ordersSum;

    @ManyToOne
    @JoinColumn(name = "orders_status_id")
    private OrderStatus orderStatus;

    @Column(name = "order_data")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderData = LocalDateTime.now();

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "confirmed_data")
    private LocalDateTime confirmedData = null;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "execute_data")
    private LocalDateTime executeData = null;

    @Column(name ="user")
    private String user;

    @Column(name = "phoneNumber")
    private String phoneNumber;


    public OrdersList() {
    }

    public OrdersList(double ordersSum, OrderStatus orderStatus, LocalDateTime orderData, LocalDateTime confirmedData, LocalDateTime executeData, String user, String phoneNumber) {
        this.ordersSum = ordersSum;
        this.orderStatus = orderStatus;
        this.orderData = orderData;
        this.confirmedData = confirmedData;
        this.executeData = executeData;
        this.user = user;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static class Builder {
        private OrdersList ordersList;

        public Builder() {
            ordersList = new OrdersList();
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

        public Builder withOrderUser(String user) {
            ordersList.user= user;
            return this;
        }

        public Builder withOrderExecuteData(String phoneNumber) {
            ordersList.phoneNumber = phoneNumber;
            return this;
        }

        public OrdersList build() {
            return new OrdersList();
        }

    }

    @Override
    public String toString() {
        return "OrdersList{" +
                "id=" + id +
                ", ordersSum=" + ordersSum +
                ", orderStatus=" + orderStatus +
                ", orderData=" + orderData +
                ", confirmedData=" + confirmedData +
                ", executeData=" + executeData +
                ", user='" + user + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

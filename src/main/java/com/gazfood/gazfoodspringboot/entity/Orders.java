package com.gazfood.gazfoodspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private long id;

    @JsonProperty("id")
    @Column(name = "dishes_id")
    private int dishesId;

    @JsonProperty("title")
    @Column(name = "dishes_name")
    private String dishesName;

    @JsonProperty("cafeteriaId")
    @Column(name = "cafeteria_id")
    private int cafeteriaId;

    @JsonProperty("cafeteriaName")
    @Column(name = "cafeteria_name")
    private String cafeteriaName;

    @JsonProperty("cost")
    @Column(name = "price")
    private double price;

    @JsonProperty("count")
    @Column(name = "count")
    private int count;

    @JsonIgnore
    @Column(name = "data")
    private LocalDateTime data = LocalDateTime.now();

    @JsonProperty("userName")
    @Column(name = "user")
    private String user;

//    @JsonProperty("tel")
    @JsonIgnore()
    @Column(name = "phone")
    private String phone;

    public Orders(int dishesId, String dishesName, int cafeteriaId, String cafeteriaName, double price, int count, LocalDateTime data, String user, String phone) {
        this.dishesId = dishesId;
        this.dishesName = dishesName;
        this.cafeteriaId = cafeteriaId;
        this.cafeteriaName = cafeteriaName;
        this.price = price;
        this.count = count;
        this.data = data;
        this.user = user;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", dishesId=" + dishesId +
                ", dishesName='" + dishesName + '\'' +
                ", cafeteriaId=" + cafeteriaId +
                ", cafeteriaName='" + cafeteriaName + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", data=" + data +
                ", user='" + user + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Orders() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDishesId() {
        return dishesId;
    }

    public void setDishesId(int dishesId) {
        this.dishesId = dishesId;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public int getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(int cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
    }

    public String getCafeteriaName() {
        return cafeteriaName;
    }

    public void setCafeteriaName(String cafeteriaName) {
        this.cafeteriaName = cafeteriaName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}

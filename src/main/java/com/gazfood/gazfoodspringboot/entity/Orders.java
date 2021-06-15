package com.gazfood.gazfoodspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

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

    @JsonIgnore
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
    private LocalDate data = LocalDate.now();

    public Orders() {
    }

    public Orders(int dishesId, String dishesName, int cafeteriaId, String cafeteriaName, double price, int count, LocalDate data) {
        this.dishesId = dishesId;
        this.dishesName = dishesName;
        this.cafeteriaId = cafeteriaId;
        this.cafeteriaName = cafeteriaName;
        this.price = price;
        this.count = count;
        this.data = data;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

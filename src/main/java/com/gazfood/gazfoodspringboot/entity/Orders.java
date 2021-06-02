package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "dishes_id")
    private int dishesId;

    @Column(name = "dishes_name")
    private String dishesName;

    @Column(name = "cafeteria_id")
    private int cafeteriaId;

    @Column(name = "cafeteria_name")
    private String cafeteriaName;

    @Column(name = "price")
    private double price;

    @Column(name = "count")
    private int count;

    @Column(name = "data")
    private LocalDate data;

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

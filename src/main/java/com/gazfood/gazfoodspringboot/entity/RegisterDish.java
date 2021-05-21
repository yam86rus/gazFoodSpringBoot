package com.gazfood.gazfoodspringboot.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "register_dishes")
public class RegisterDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dish_data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dishData;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public RegisterDish(LocalDate dishData, double price, Dish dish) {
        this.dishData = dishData;
        this.price = price;
        this.dish = dish;
    }

    public RegisterDish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDishData() {
        return dishData;
    }

    public void setDishData(LocalDate dishData) {
        this.dishData = dishData;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}

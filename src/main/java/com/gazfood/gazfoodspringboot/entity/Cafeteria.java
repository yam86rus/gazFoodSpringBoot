package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "cafeterias")
public class Cafeteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "time_of_delivery")
    private int timeOfDelivery;

    @Column(name = "stars")
    private double stars;

    @Column(name = "price")
    private int price;

    @Column(name = "kitchen")
    private String kitchen;

    @Column(name = "image")
    private String image;

    @Column(name = "products")
    private String products;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "active")
    private boolean active;

    public Cafeteria() {
    }

    public Cafeteria(String name, int timeOfDelivery, double stars, int price, String kitchen, String image, String products, String address, String phone, boolean active) {
        this.name = name;
        this.timeOfDelivery = timeOfDelivery;
        this.stars = stars;
        this.price = price;
        this.kitchen = kitchen;
        this.image = image;
        this.products = products;
        this.address = address;
        this.phone = phone;
        this.active = active;
    }

    public int getTimeOfDelivery() {
        return timeOfDelivery;
    }

    public void setTimeOfDelivery(int timeOfDelivery) {
        this.timeOfDelivery = timeOfDelivery;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name="dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "structure")
    private String structure;

    @Column(name = "weight")
    private double weight;

    @Column(name="price")
    private double price;

    @Column(name = "category")
    private String category;

    public Dish() {
    }

    public Dish(String name, String structure, double weight, double price, String category) {
        this.name = name;
        this.structure = structure;
        this.weight = weight;
        this.price = price;
        this.category = category;
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
        this.name = name;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

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

    @ManyToOne
    @JoinColumn(name = "dishCategory_id")
    private DishCategory dishCategory;

    public Dish() {
    }

    public Dish(String name, String structure, double weight, DishCategory dishCategory) {
        this.name = name;
        this.structure = structure;
        this.weight = weight;
        this.dishCategory = dishCategory;
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



    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }
}

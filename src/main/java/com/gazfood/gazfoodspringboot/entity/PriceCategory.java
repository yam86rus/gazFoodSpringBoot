package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "price_categories")
public class PriceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Название не может быть пустым")
    @Size(min=2, max=200, message = "Длина названия должна быть в диапазоне от 2 до 200")
    private String name;

    @NotEmpty(message = "Название не может быть пустым")
    @Size(min=2, max=200, message = "Длина описания должна быть в диапазоне от 2 до 200")
    @Column(name = "description")
    private String description;

    public PriceCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PriceCategory() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

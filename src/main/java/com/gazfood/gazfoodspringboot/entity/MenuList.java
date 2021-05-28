package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "menu_list")
public class MenuList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Название не может быть пустым")
    @Size(min=2, max=200, message = "Длина названия должна быть в диапазоне от 2 до 200")
    private String name;

    @Column(name = "description")
    @NotEmpty(message = "Описание не может быть пустым")
    @Size(min=2, max=200, message = "Длина описания должна быть в диапазоне от 2 до 200")
    private String description;

    @ManyToOne
    @JoinColumn(name = "priceCategory_id")
    private PriceCategory priceCategory;

    public MenuList() {
    }

    public MenuList(String name, String description, PriceCategory priceCategory) {
        this.name = name;
        this.description = description;
        this.priceCategory = priceCategory;
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

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }
}

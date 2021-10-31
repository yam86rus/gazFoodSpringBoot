package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "unit_name")
    private String unitName;

    public Unit() {
    }

    public Unit(String unitName) {
        this.unitName = unitName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}

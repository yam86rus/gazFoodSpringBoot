package com.gazfood.gazfoodspringboot.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "inventory_name")
    private String InventoryName;

    @Column(name = "inventory_number")
    private String inventoryNumber;

    @Column(name = "place")
    private String place;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private double price;

    @Column(name = "inventory_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inventoryDate;

    @Column(name = "responsible")
    private String responsible;

    @Column(name="address")
    private String address;

    @Column(name = "editing_person")
    private String editingPerson;

    @Column(name = "editing_date")
    private LocalDate editingDate;

    public Inventory() {
    }

    public Inventory(String inventoryName, String inventoryNumber, String place, int count, double price, LocalDate inventoryDate, String responsible, String address, String editingPerson, LocalDate editingDate) {
        InventoryName = inventoryName;
        this.inventoryNumber = inventoryNumber;
        this.place = place;
        this.count = count;
        this.price = price;
        this.inventoryDate = inventoryDate;
        this.responsible = responsible;
        this.address = address;
        this.editingPerson = editingPerson;
        this.editingDate = editingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInventoryName() {
        return InventoryName;
    }

    public void setInventoryName(String inventoryName) {
        InventoryName = inventoryName;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(LocalDate inventoryDate) {
        this.inventoryDate = inventoryDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEditingPerson() {
        return editingPerson;
    }

    public void setEditingPerson(String editingPerson) {
        this.editingPerson = editingPerson;
    }

    public LocalDate getEditingDate() {
        return editingDate;
    }

    public void setEditingDate(LocalDate editingDate) {
        this.editingDate = editingDate;
    }
}

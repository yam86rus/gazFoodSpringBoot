package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "recept")
public class Recept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "recept_code")
    private String code;

    @Column(name = "recept_document")
    private String document;

    @Column(name = "recept_name")
    private String receptName;

    @Column(name = "recept_exit")
    private String exit;

    @Column(name = "price_sebestoimost")
    private double priceSebestoimost;


    @Column(name = "price_prodaja")
    private double priceProdaja;

    public Recept() {
    }

    public Recept(String code, String document, String receptName, String exit, double priceSebestoimost, double priceProdaja) {
        this.code = code;
        this.document = document;
        this.receptName = receptName;
        this.exit = exit;
        this.priceSebestoimost = priceSebestoimost;
        this.priceProdaja = priceProdaja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getReceptName() {
        return receptName;
    }

    public void setReceptName(String receptName) {
        this.receptName = receptName;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public double getPriceSebestoimost() {
        return priceSebestoimost;
    }

    public void setPriceSebestoimost(double priceSebestoimost) {
        this.priceSebestoimost = priceSebestoimost;
    }

    public double getPriceProdaja() {
        return priceProdaja;
    }

    public void setPriceProdaja(double priceProdaja) {
        this.priceProdaja = priceProdaja;
    }
}

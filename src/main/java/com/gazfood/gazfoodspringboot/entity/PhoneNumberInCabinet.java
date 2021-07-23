package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone_number_in_cabinet")
public class PhoneNumberInCabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cabinet")
    private int cabinet;

    @Column(name = "socket")
    private String socket;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "phone_number_city")
    private String phoneNumberCity;

    @Column(name = "department")
    private String department;

    public PhoneNumberInCabinet() {
    }

    public PhoneNumberInCabinet(int cabinet, String socket, String phoneNumber, String phoneNumberCity, String department) {
        this.cabinet = cabinet;
        this.socket = socket;
        this.phoneNumber = phoneNumber;
        this.phoneNumberCity = phoneNumberCity;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneNumberCity() {
        return phoneNumberCity;
    }

    public void setPhoneNumberCity(String phoneNumberCity) {
        this.phoneNumberCity = phoneNumberCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCabinet() {
        return cabinet;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

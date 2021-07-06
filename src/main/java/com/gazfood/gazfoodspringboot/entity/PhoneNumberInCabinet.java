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

    public PhoneNumberInCabinet() {
    }

    public PhoneNumberInCabinet(int cabinet, String socket, String phoneNumber) {
        this.cabinet = cabinet;
        this.socket = socket;
        this.phoneNumber = phoneNumber;
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

package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "position")
    private String position;

    @Column(name = "department")
    private String department;

    @Column (name = "city")
    private String city;

    @Column(name = "phoneGaz")
    private String phoneGaz;

    @Column(name = "phoneMobile")
    private String phoneMobile;

    @Column(name = "email")
    private String email;

    public Employee() {
    }

    public Employee(String name, String surname, String patronymic, String birthday, String position, String department, String city, String phoneGaz, String phoneMobile, String email) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.position = position;
        this.department = department;
        this.city = city;
        this.phoneGaz = phoneGaz;
        this.phoneMobile = phoneMobile;
        this.email = email;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneGaz() {
        return phoneGaz;
    }

    public void setPhoneGaz(String phoneGaz) {
        this.phoneGaz = phoneGaz;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "partners")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(name = "partner_inn")
    private String partnerInn;

    @Column(name = "partner_kpp")
    private String partnerKpp;

    @Column(name = "partner_adress")
    private String partnerAdress;

    @Column(name = "personal_manager")
    private String personalManager;

    @Column(name = "manager_mobile_phone")
    private String managerMobilePhone;

    @Column(name = "manager_city_phone")
    private String mangerCityPhone;

    @Column(name = "manager_email")
    private String managerEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerInn() {
        return partnerInn;
    }

    public void setPartnerInn(String partnerInn) {
        this.partnerInn = partnerInn;
    }

    public String getPartnerKpp() {
        return partnerKpp;
    }

    public void setPartnerKpp(String partnerKpp) {
        this.partnerKpp = partnerKpp;
    }

    public String getPartnerAdress() {
        return partnerAdress;
    }

    public void setPartnerAdress(String partnerAdress) {
        this.partnerAdress = partnerAdress;
    }

    public String getPersonalManager() {
        return personalManager;
    }

    public void setPersonalManager(String personalManager) {
        this.personalManager = personalManager;
    }

    public String getManagerMobilePhone() {
        return managerMobilePhone;
    }

    public void setManagerMobilePhone(String managerMobilePhone) {
        this.managerMobilePhone = managerMobilePhone;
    }

    public String getMangerCityPhone() {
        return mangerCityPhone;
    }

    public void setMangerCityPhone(String mangerCityPhone) {
        this.mangerCityPhone = mangerCityPhone;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public Partner() {
    }

    public Partner(String partnerName, String partnerInn, String partnerKpp, String partnerAdress, String personalManager, String managerMobilePhone, String mangerCityPhone, String managerEmail) {
        this.partnerName = partnerName;
        this.partnerInn = partnerInn;
        this.partnerKpp = partnerKpp;
        this.partnerAdress = partnerAdress;
        this.personalManager = personalManager;
        this.managerMobilePhone = managerMobilePhone;
        this.mangerCityPhone = mangerCityPhone;
        this.managerEmail = managerEmail;
    }
}

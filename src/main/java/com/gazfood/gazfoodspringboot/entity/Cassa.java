package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "casses")
public class Cassa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="cassa_name")
    private String cassaName;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "ammy_admin")
    private String ammyAdmin;

    @Column(name = "any_desk")
    private String annyDesk;

    @Column(name = "computer_name")
    private String computerName;

    @Column(name = "cassa_address")
    private String cassaAdres;

    @Column(name = "data_update")
    private String dataUpdate;

    @Column(name = "temp")
    private String temp;

    @Column(name = "fn_deadline_data")
    private String fnDeadlineData;

    @Column(name = "kpp")
    private String kpp;

    @Column(name = "rnkkt")
    private String rnkkt;

    @Column(name="fn_number")
    private String fnNumber;

    @Column(name = "mob_number")
    private String mobileNumber;

    @Column(name = "icc_number")
    private String iccNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getIccNumber() {
        return iccNumber;
    }

    public void setIccNumber(String iccNumber) {
        this.iccNumber = iccNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCassaName() {
        return cassaName;
    }

    public void setCassaName(String cassaName) {
        this.cassaName = cassaName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getAmmyAdmin() {
        return ammyAdmin;
    }

    public void setAmmyAdmin(String ammyAdmin) {
        this.ammyAdmin = ammyAdmin;
    }

    public String getAnnyDesk() {
        return annyDesk;
    }

    public void setAnnyDesk(String annyDesk) {
        this.annyDesk = annyDesk;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getCassaAdres() {
        return cassaAdres;
    }

    public void setCassaAdres(String cassaAdres) {
        this.cassaAdres = cassaAdres;
    }

    public String getDataUpdate() {
        return dataUpdate;
    }

    public void setDataUpdate(String dataUpdate) {
        this.dataUpdate = dataUpdate;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFnDeadlineData() {
        return fnDeadlineData;
    }

    public void setFnDeadlineData(String fnDeadlineData) {
        this.fnDeadlineData = fnDeadlineData;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getRnkkt() {
        return rnkkt;
    }

    public void setRnkkt(String rnkkt) {
        this.rnkkt = rnkkt;
    }

    public String getFnNumber() {
        return fnNumber;
    }

    public void setFnNumber(String fnNumber) {
        this.fnNumber = fnNumber;
    }

    public Cassa() {
    }

    public Cassa(String cassaName, String prefix, String ammyAdmin, String annyDesk, String computerName, String cassaAdres, String dataUpdate, String temp, String fnDeadlineData, String kpp, String rnkkt, String fnNumber, String mobileNumber, String iccNumber) {
        this.cassaName = cassaName;
        this.prefix = prefix;
        this.ammyAdmin = ammyAdmin;
        this.annyDesk = annyDesk;
        this.computerName = computerName;
        this.cassaAdres = cassaAdres;
        this.dataUpdate = dataUpdate;
        this.temp = temp;
        this.fnDeadlineData = fnDeadlineData;
        this.kpp = kpp;
        this.rnkkt = rnkkt;
        this.fnNumber = fnNumber;
        this.mobileNumber = mobileNumber;
        this.iccNumber = iccNumber;
    }
}

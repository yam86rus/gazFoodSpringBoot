package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "contract_name")
    private String contractName;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "contract_data")
    private String contractData;

    @ManyToOne
    @JoinColumn(name = "contract_partner_id")
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "contract_status_id")
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractData() {
        return contractData;
    }

    public void setContractData(String contractData) {
        this.contractData = contractData;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Contract() {
    }

    public Contract(String contractName, String contractNumber, String contractData, Partner partner, Status status) {
        this.contractName = contractName;
        this.contractNumber = contractNumber;
        this.contractData = contractData;
        this.partner = partner;
        this.status = status;
    }
}

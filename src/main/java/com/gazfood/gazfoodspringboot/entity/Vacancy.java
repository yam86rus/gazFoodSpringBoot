package com.gazfood.gazfoodspringboot.entity;

import com.gazfood.gazfoodspringboot.enums.ContractType;

import javax.persistence.*;

@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "vacancy_name")
    private String vacancyName;

    @Column(name = "description")
    private String description;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "conditions")
    private String conditions;

    @Column(name = "contacts")
    private String contacts;
//
//    @Enumerated(EnumType.ORDINAL)
//    private WorkTime workTime;

    @Column(name = "contract_type")
    @Enumerated(EnumType.STRING)
    private ContractType element;

    public Vacancy() {
    }

    public Vacancy(String vacancyName, String description, String requirements, String conditions, String contacts, ContractType element) {
        this.vacancyName = vacancyName;
        this.description = description;
        this.requirements = requirements;
        this.conditions = conditions;
        this.contacts = contacts;
        this.element = element;
    }

    public ContractType getElement() {
        return element;
    }

    public void setElement(ContractType element) {
        this.element = element;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}

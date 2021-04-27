package com.gazfood.gazfoodspringboot.enums;

public enum ContractType {
    e1("Полная занятость"),
    e2("Частичная занятость"),
    e3("Проектная работа / разовое задание"),
    e4("Волонтерство"),
    e5("Стажировка");

    public final String label;

    ContractType(String label) {
        this.label = label;
    }
}

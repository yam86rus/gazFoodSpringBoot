package com.gazfood.gazfoodspringboot.enums;

public enum Experience {
    e1("Не имеет значения"),
    e2("Нет опыта"),
    e3("От 1 года до 3-х лет"),
    e4("от 3 до 6 лет"),
    e5("Более 6 лет");

    public final String label;

    Experience(String label) {
        this.label = label;
    }
}

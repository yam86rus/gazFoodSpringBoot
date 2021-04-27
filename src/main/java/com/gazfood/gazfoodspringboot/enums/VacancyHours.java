package com.gazfood.gazfoodspringboot.enums;

public enum VacancyHours {
    e1("Полный день"),
    e2("Сменный график"),
    e3("Гибкий график"),
    e4("Удаленная работа"),
    e5("Вахтовый метод");

    public final String label;

    VacancyHours(String label) {
        this.label = label;
    }
}

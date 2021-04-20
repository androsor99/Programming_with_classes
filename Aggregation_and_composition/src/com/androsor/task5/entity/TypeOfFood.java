package com.androsor.task5.entity;

import java.util.Arrays;
import java.util.List;

public enum TypeOfFood {

    NOT_INCLUDED("Без питания"),
    BREAKFAST("Завтрак"),
    ALL_INCLUSIVE("Все включено");

    private final String type;

    TypeOfFood(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static List<TypeOfFood> getFoods() {
        return Arrays.asList(NOT_INCLUDED, BREAKFAST, ALL_INCLUSIVE);
    }
}

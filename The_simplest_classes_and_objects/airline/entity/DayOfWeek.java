package com.androsor.prog_class.airline.entity;

import java.util.Arrays;
import java.util.List;

public enum DayOfWeek {

    SUNDAY ("Воскресенье"),
    MONDAY ("Понедельник"),
    TUESDAY ("Вторник"),
    WEDNESDAY ("Среда"),
    THURSDAY ("Четверг"),
    FRIDAY ("Пятница"),
    SATURDAY ("Суббота"),
    EVERYDAY("Ежедневно");

    private final String title;
    public static List<DayOfWeek> sortingDayOfWeek = Arrays.asList(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, EVERYDAY);

    DayOfWeek(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("%s", title);
    }
}

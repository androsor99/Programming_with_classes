package com.androsor.task5.service;

import com.androsor.task5.entity.Tour;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Comparator.comparing;

public enum TypeOfTourSorting {

    SORT_BY_COUNTRY(tours -> tours.sort(comparing(Tour::getCountry))),
    SORT_BY_PRICE(tours -> tours.sort(comparing(Tour::getPrice))),
    SORT_BY_DAYS(tours -> tours.sort(comparing(Tour::getNumberOfDays)));

    private final Consumer<List<Tour>> typeOfTourSorting;

    TypeOfTourSorting(Consumer<List<Tour>> typeOfTourSorting) {
        this.typeOfTourSorting = typeOfTourSorting;
    }

    public Consumer<List<Tour>> getTypeOfTourSorting() {
        return typeOfTourSorting;
    }
}

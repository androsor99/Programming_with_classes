package com.androsor.task5.service;

import com.androsor.task5.entity.Tour;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public enum TypeOfTourSelection {

    SELECT_BY_TYPE((tours, userType) -> tours.stream()
            .filter(tour -> tour.getTourType().getType().equalsIgnoreCase(userType))
            .collect(toList())),
    SELECT_BY_COUNTRY((tours, userCountry) -> tours.stream()
            .filter(tour -> tour.getCountry().equalsIgnoreCase(userCountry))
            .collect(toList())),
    SELECT_BY_TYPE_OF_FOOD((tours, userFood) -> tours.stream()
            .filter(tour -> tour.getTypeOfFood().getType().equalsIgnoreCase(userFood))
            .collect(toList())),
    SELECT_BY_TRANSPORT((tours, userTransport) -> tours.stream()
            .filter(tour -> tour.getTransport().getType().equalsIgnoreCase(userTransport))
            .collect(toList())),
    SELECT_BY_PRICE((tours, userPrice) -> getStream(tours)
            .filter(tour -> tour.getPrice().compareTo(new BigDecimal(userPrice.trim())) <= 0)
            .collect(toList())),
    SELECT_BY_NUMBER_DAYS((tours, userNumberOfDays) -> getStream(tours)
            .filter(tour -> tour.getNumberOfDays() <= Integer.parseInt (userNumberOfDays.trim()))
            .collect(toList()));



    private final BiFunction<List<Tour>, String, List<Tour> > typeOfTourSelection;


    TypeOfTourSelection(BiFunction<List<Tour>, String, List<Tour>> typeOfTourSelection) {
        this.typeOfTourSelection = typeOfTourSelection;
    }

    public BiFunction<List<Tour>, String, List<Tour>> getTypeOfTourSelection() {
        return typeOfTourSelection;
    }

    private static Stream<Tour> getStream(List<Tour> tours) {
        return tours.stream();
    }


}

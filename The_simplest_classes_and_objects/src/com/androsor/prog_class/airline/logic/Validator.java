package com.androsor.prog_class.airline.logic;

import com.androsor.prog_class.airline.entity.Airline;

import java.util.List;

public class Validator {

    public static List<Airline> checkFlightAvailability(List<Airline> airlines) {
        if (!airlines.isEmpty()) {
            return airlines;
        } else {
            throw new IllegalArgumentException("Ничего не найдено.");
        }
    }
}

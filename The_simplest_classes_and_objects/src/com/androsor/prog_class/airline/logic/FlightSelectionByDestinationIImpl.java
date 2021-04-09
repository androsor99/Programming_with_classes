package com.androsor.prog_class.airline.logic;

import com.androsor.prog_class.airline.entity.Airline;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.androsor.prog_class.airline.logic.Validator.checkFlightAvailability;

public class FlightSelectionByDestinationIImpl implements FlightSelection {

    private final String INPUT_MESSAGE = "Введите пункт назначения:\n";
    private final String OUTPUT_MESSAGE = "Список рейсов для заданного пункта назначения:\n";

    @Override
    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    @Override
    public String getOutputMessage() {
        return OUTPUT_MESSAGE;
    }

    @Override
    public List<Airline> getFlightSchedule(List<Airline> airlines, String destination) {
        Predicate<Airline> isContainsDestination = airline -> airline.getDestination().equalsIgnoreCase(destination);
        List<Airline> result = airlines.stream()
                .filter(isContainsDestination)
                .collect(Collectors.toList());
        return checkFlightAvailability(result);
    }
}

package com.androsor.prog_class.airline.logic;

import com.androsor.prog_class.airline.entity.Airline;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.androsor.prog_class.airline.logic.Validator.checkFlightAvailability;

public class FlightSelectionByDaysOfWeekImpl implements FlightSelection {

    private final String INPUT_MESSAGE = "Введите день недели:\n";
    private final String OUTPUT_MESSAGE = "Список рейсов заданного дня недели:\n";

    @Override
    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    @Override
    public String getOutputMessage() {
        return OUTPUT_MESSAGE;
    }

    @Override
    public List<Airline> getFlightSchedule(List<Airline> airlines, String dayOfWeek) {
        Predicate<Airline> isContainsDayOfWeek = airline -> airline.getDayOfWeeks().contains(dayOfWeek.toUpperCase(Locale.ROOT))
                || airline.getDayOfWeeks().contains("ЕЖЕДНЕВНО");
        List<Airline> result = airlines.stream()
                .filter(isContainsDayOfWeek)
                .collect(Collectors.toList());
        return checkFlightAvailability(result);
    }
}

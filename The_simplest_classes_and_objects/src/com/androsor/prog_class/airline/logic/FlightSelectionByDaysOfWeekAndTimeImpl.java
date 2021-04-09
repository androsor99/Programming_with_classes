package com.androsor.prog_class.airline.logic;

import com.androsor.prog_class.airline.entity.Airline;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.androsor.prog_class.airline.logic.Validator.checkFlightAvailability;
import static com.androsor.prog_class.airline.utils.Parser.parseDayAndTimeFromString;

public class FlightSelectionByDaysOfWeekAndTimeImpl implements FlightSelection {

    private final String INPUT_MESSAGE = "Введите день недели и время вылета в формате (ДЕНЬ НЕДЕЛИ ЧЧ:ММ):\n";
    private final String OUTPUT_MESSAGE = "Список рейсов для заданного дня недели и времени вылета:\n";
    private final FlightSelectionByDaysOfWeekImpl flightSelectionByDaysOfWeek = new FlightSelectionByDaysOfWeekImpl();

    @Override
    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    @Override
    public String getOutputMessage() {
        return OUTPUT_MESSAGE;
    }

    @Override
    public List<Airline> getFlightSchedule(List<Airline> airlines, String parseLine) {
        String dayOfWeek = parseDayAndTimeFromString(parseLine, "Day");
        String time = parseDayAndTimeFromString(parseLine, "Time");
        List<Airline> flightsByDayOfWeek = flightSelectionByDaysOfWeek.getFlightSchedule(airlines, dayOfWeek);
        Predicate<Airline> isContainsTime = airline -> airline.getDepartureTime().compareTo(time) > 0;
        List<Airline> result = flightsByDayOfWeek.stream()
                .filter(isContainsTime)
                .collect(Collectors.toList());
        return checkFlightAvailability(result);
    }
}

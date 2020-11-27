package com.androsor.prog_class.airline.logic;

import com.androsor.prog_class.airline.entity.Airline;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static com.androsor.prog_class.airline.entity.DayOfWeek.*;
import static com.androsor.prog_class.airline.entity.FlightScheduleCommand.*;
import static com.androsor.prog_class.airline.view.FlightScheduleView.getStringHelperOfFlightSchedule;

public class FlightSchedule {

    private ArrayList<Airline> airlines;
    private final String ERROR_MESSAGE = "По Вашим данным рейсов не найдено";

    public FlightSchedule(ArrayList<Airline> airline) {
        this.airlines = airline;
    }

    public void addAirline(String destination, String flightNumber, String planeType, Date departureTime, String[] dayOfWeek) {
        airlines.add(new Airline(destination, flightNumber, planeType, departureTime, dayOfWeek));
    }

    public ArrayList<Airline> createFlightScheduleByDestination() {
        String userStringCommand = getStringHelperOfFlightSchedule(FLIGHT_SCHEDULE_BY_DESTINATION);
        ArrayList<Airline> airlines = new ArrayList<>();
        for (Airline airline : this.airlines) {
            if (airline.getDestination().equalsIgnoreCase(userStringCommand)) {
                airlines.add(airline);
            }
        }
        if (airlines.size() == 0) {
            System.out.println(ERROR_MESSAGE);
        }
        return airlines;
    }

    public ArrayList<Airline> createFlightScheduleByDays() {
        String userDayOfWeek = getStringHelperOfFlightSchedule(FLIGHT_SCHEDULE_BY_DAY_OF_WEEK);
        ArrayList<Airline> airlines = new ArrayList<>();
        for (Airline airline : this.airlines) {
            for (String day : airline.getDayOfWeek()) {
                if (day.equalsIgnoreCase(userDayOfWeek) || day.equalsIgnoreCase(EVERYDAY.getTitle())) {
                    airlines.add(airline);
                    break;
                }
            }
        }
        if (airlines.size() == 0) {
            System.out.println(ERROR_MESSAGE);
        }
        return airlines;
    }

    public ArrayList<Airline> createFlightScheduleByDaysAndTime() throws ParseException {
        String userDayOfWeek = getStringHelperOfFlightSchedule(FLIGHT_SCHEDULE_BY_DAY_OF_WEEK);
        String userTime = getStringHelperOfFlightSchedule(FLIGHT_SCHEDULE_BY_DAY_OF_WEEK_AND_DEPARTURE_TIME);
        Date time = Airline.ft.parse(userTime);
        ArrayList<Airline> airlines = new ArrayList<>();
        for (Airline airline : this.airlines) {
            for (String day : airline.getDayOfWeek()) {
                if (day.equalsIgnoreCase(userDayOfWeek) || day.equalsIgnoreCase(EVERYDAY.getTitle())) {
                    if (airline.getDepartureTime().compareTo(time) >= 0) {
                        airlines.add(airline);
                        break;
                    }
                }
            }
        }
        if (airlines.size() == 0) {
            System.out.println(ERROR_MESSAGE);
        }
        return airlines;
    }

    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(ArrayList<Airline> airlines) {
        this.airlines = airlines;
    }
}

package com.androsor.prog_class.airline.entity;

import com.androsor.prog_class.airline.logic.FlightSelection;

import java.util.List;

import static com.androsor.prog_class.airline.utils.IOHelper.enterParameter;
import static com.androsor.prog_class.airline.utils.IOHelper.printFlights;

public class Airport {

    private List<Airline> airlines;

    public Airport(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public void createFlightSchedule(int code) {
        try {
            FlightSelection flightSelection = FlightScheduleType.getFlightScheduleType(code).getFlightSelection();
            String inputMessage = flightSelection.getInputMessage();
            String parameter = enterParameter(inputMessage);
            String outputMessage = flightSelection.getOutputMessage();
            System.out.println(outputMessage);
            List<Airline> selectedFlights = flightSelection.getFlightSchedule(this.airlines, parameter);
            printFlights(selectedFlights);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

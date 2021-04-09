package com.androsor.prog_class.airline.logic;

import com.androsor.prog_class.airline.entity.Airline;

import java.util.List;

public interface FlightSelection {

    /**
     * Returns a list of airlines selected by the specified parameters.
     * @param airlines a list from which to select airlines.
     * @param parameter parameter by which the selection of airlines will be made.
     * @return list of airlines.
     */
    List<Airline> getFlightSchedule(List<Airline> airlines, String parameter);

    /**
     * Returns a string with a message for entering parameters
     * @return String with a message.
     */
    String getInputMessage();

    /**
     *Returns a string with a message for outputting parameters
     * @return string with a message.
     */
    String getOutputMessage();
}

package com.androsor.prog_class.airline.main;

import com.androsor.prog_class.airline.entity.Airport;

import static com.androsor.prog_class.airline.utils.IOHelper.*;

/**
 * Create an Airline class whose specification is given below. Define constructors, set and get methods, and the toString () method.
 * Create a second class that aggregates the Airline array with appropriate constructors and methods.
 * Set the criteria for selecting data and display this data on the console.
 *
 * Airline: destination, flight number, aircraft type, departure time, days of the week.
 *
 * Find and withdraw:
 *
 * a) a list of flights for a given destination;
 *
 * b) list of flights for a given day of the week;
 *
 * c) a list of flights for a given day of the week, the departure time for which is greater than the given one.
 */
public class Runner {

    public static void main(String[] args) {
        Airport myFlights = new Airport(readFlightSchedule());
        printFlights(myFlights.getAirlines());
        enterOptionsFlightSchedule();

        while (true) {
            int userCommand = enterUserCommand();
            myFlights.createFlightSchedule(userCommand);
        }
    }
}


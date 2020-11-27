package com.androsor.prog_class.airline.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import com.androsor.prog_class.airline.logic.FlightSchedule;
import com.androsor.prog_class.airline.entity.FlightScheduleCommand;

import static com.androsor.prog_class.airline.entity.FlightScheduleCommand.*;
import static com.androsor.prog_class.airline.view.FlightScheduleView.*;
import static com.androsor.prog_class.airline.view.ReadingFlightSchedule.readFlightSchedule;

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

public class AirlineMain {

    public static void main(String[] args) throws ParseException, IOException {

        FlightSchedule flightSchedule = new FlightSchedule(readFlightSchedule());

        enterOptionsFlightSchedule();

        int userCommand;

        do {
            userCommand = enterFromConsoleCommandInt("Введите команду:\n-> ");
            FlightScheduleCommand command = getScheduleCommandByCode(userCommand);

            if (command != null) {
                processCommand(command, flightSchedule);
            } else {
                System.out.print("Неверная команда. ");
            }
        } while (userCommand != EXIT_PROGRAM.getCode());

    }

    private static void processCommand(FlightScheduleCommand com, FlightSchedule temp) throws IOException, ParseException {

        switch (com) {
            case SHOW_FLIGHT_SCHEDULE -> showFlightSchedule(readFlightSchedule(), getNameOfFlightSchedule(com));
            case FLIGHT_SCHEDULE_BY_DESTINATION -> showFlightSchedule(temp.createFlightScheduleByDestination(), getNameOfFlightSchedule(com));
            case FLIGHT_SCHEDULE_BY_DAY_OF_WEEK -> showFlightSchedule(temp.createFlightScheduleByDays(), getNameOfFlightSchedule(com));
            case FLIGHT_SCHEDULE_BY_DAY_OF_WEEK_AND_DEPARTURE_TIME -> showFlightSchedule(temp.createFlightScheduleByDaysAndTime(), getNameOfFlightSchedule(com));
        }
    }

    public static int enterFromConsoleCommandInt(String massage) {

        System.out.print(massage);
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.print("Введенное значение не является числом. Повторите ввод:\n-> ");
            sc.next();
        }
        return sc.nextInt();
    }
}


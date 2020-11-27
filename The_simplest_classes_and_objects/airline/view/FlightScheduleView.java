package com.androsor.prog_class.airline.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.androsor.prog_class.airline.entity.Airline;
import com.androsor.prog_class.airline.entity.FlightScheduleCommand;

import static com.androsor.prog_class.airline.entity.FlightScheduleCommand.*;

public class FlightScheduleView {

    public static void showFlightSchedule(ArrayList<Airline> airlines, String nameOfSchedule) {
        System.out.print(nameOfSchedule);
        for (Airline airline : airlines) {
            System.out.print(airline);
        }
    }

    public static String getNameOfFlightSchedule(FlightScheduleCommand command) {

        switch (command) {

            case SHOW_FLIGHT_SCHEDULE -> {return ("Расписание полетов:\n---------------------------\n");}
            case FLIGHT_SCHEDULE_BY_DESTINATION -> {return "Расписание полетов по месту назначения :\n----------------------------------\n";}
            case FLIGHT_SCHEDULE_BY_DAY_OF_WEEK -> {return "Расписание полётов по дням вылетов:\n----------------------------------\n";}
            case FLIGHT_SCHEDULE_BY_DAY_OF_WEEK_AND_DEPARTURE_TIME -> {return "Расписание полётов по дням и времени вылетов :\n----------------------------------\n";}
        }
        return null;
    }

    public static String getStringHelperOfFlightSchedule(FlightScheduleCommand command) {

        switch (command) {

            case FLIGHT_SCHEDULE_BY_DESTINATION -> {return enterFromConsoleCommandString("Введите город прибытия ->\n");}
            case FLIGHT_SCHEDULE_BY_DAY_OF_WEEK -> {return enterFromConsoleCommandString("Введите день вылета ->\n");}
            case FLIGHT_SCHEDULE_BY_DAY_OF_WEEK_AND_DEPARTURE_TIME -> {return enterFromConsoleCommandString("Введите время для вывода рейсов время вылета которых больше заданного ->\n");}
        }
        return null;
    }

    public static void enterOptionsFlightSchedule () {

        System.out.printf("Введите -%d- чтобы вывести расписание полетов \n",SHOW_FLIGHT_SCHEDULE.getCode());
        System.out.printf("Введите -%d- чтобы вывести расписание полетов по месту назначения  \n", FLIGHT_SCHEDULE_BY_DESTINATION.getCode());
        System.out.printf("Введите -%d- чтобы вывести расписание полётов по дням вылетов \n", FLIGHT_SCHEDULE_BY_DAY_OF_WEEK.getCode());
        System.out.printf("Введите -%d- чтобы вывести расписание полётов по дням и времени вылетов  \n", FLIGHT_SCHEDULE_BY_DAY_OF_WEEK_AND_DEPARTURE_TIME.getCode());
        System.out.printf("Введите -%d- чтобы завершить программу \n", EXIT_PROGRAM.getCode());
    }

    public static String enterFromConsoleCommandString(String massage) {

        System.out.print(massage);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}

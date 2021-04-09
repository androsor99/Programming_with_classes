package com.androsor.prog_class.airline.utils;

import com.androsor.prog_class.airline.entity.Airline;
import com.androsor.prog_class.airline.entity.FlightScheduleType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class IOHelper {

    public static void enterOptionsFlightSchedule () {
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("Введите -%d- чтобы вывести расписание полетов по месту назначения  \n", FlightScheduleType.FLIGHT_SCHEDULE_BY_DESTINATION.getTypeCode());
        System.out.printf("Введите -%d- чтобы вывести расписание полётов по дням вылетов \n", FlightScheduleType.FLIGHT_SCHEDULE_BY_DAY_OF_WEEK.getTypeCode());
        System.out.printf("Введите -%d- чтобы вывести расписание полётов по дням и времени вылетов  \n", FlightScheduleType.FLIGHT_SCHEDULE_BY_DAY_OF_WEEK_AND_DEPARTURE_TIME.getTypeCode());
        System.out.print("Введите -9- чтобы завершить программу \n");
        System.out.println("-----------------------------------------------------------------");
    }

    public static String enterParameter(String massage) {
        System.out.print(massage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int enterUserCommand() {
        int userCommand = 0;
        try {
            userCommand = Integer.parseInt(enterParameter("Введите команду:\n-> "));
            if (userCommand == 9) {
                System.exit(9);
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверная строка в аргументе");
        }
        return userCommand;
    }

    public static List<Airline> readFlightSchedule() {
        List<Airline> flightSchedule = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/androsor/prog_class/airline/resource/FlightSchedule.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\|");
                String[] lines = pattern.split(line);
                String linesDay = lines[4].toUpperCase(Locale.ROOT);
                Pattern patternDayOfWeek = Pattern.compile("\\.");
                List<String> daysOfWeek = Arrays.asList(patternDayOfWeek.split(linesDay));
                flightSchedule.add(new Airline(lines[0], lines[1], lines[2], lines[3], daysOfWeek));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flightSchedule;
    }

    public static void printFlights(List<Airline> flights) {
        for (Airline flight : flights) {
            System.out.println(flight);
        }
    }
}

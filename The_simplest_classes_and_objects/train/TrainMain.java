package com.androsor.prog_class.train;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static com.androsor.prog_class.train.ReadSchedule.*;
import static com.androsor.prog_class.train.ScheduleCommand.*;

/**
 * Create a Train class containing fields: destination name, train number, departure time. Create data into an array of
 * five elements of the Train type, add the ability to sort the array elements by train numbers.
 * Add the ability to display information about the train, the number of which is entered by the user.
 * Add the ability to sort the array by destination, with trains with the same destination sorted by departure time.
 */

public class TrainMain {

    private static final String TRAIN_INFORMATION = "Поезд №-%s\t\t%s\t\t%s\n";

    public static void main(String[] args) throws IOException {

        Train[] trainList = readSchedule();
        enterOptionsSchedule();

        int userCommand;

        do {
            userCommand = enterFromConsole("Введите команду:\n-> ");
            ScheduleCommand command = getScheduleCommandByCode(userCommand);

            if (command != null) {
                processCommand(command, trainList);
            } else {
                System.out.print("Неверная команда. ");
            }
        } while (userCommand != EXIT_PROGRAM.getCode());
    }

    public static void showTrainSchedule(Train[] trains, String nameOfSchedule) {

        System.out.print(nameOfSchedule);
        for (Train train : trains) {
            System.out.printf(TRAIN_INFORMATION, train.getNumber(), train.getDestination(), train.getDepartureTime());
        }
        System.out.println("----------------------------------");
    }

    public static int enterFromConsole(String massage) {

        System.out.print(massage);
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.print("Введенное значение не является числом. Повторите ввод:\n-> ");

            sc.next();
        }
        return sc.nextInt();
    }

    public static void showTrainInformation(Train[] trains) {

        boolean flag = true;
        while (flag) {

            int trainNumberCurrent = enterFromConsole("Введите номер позда:\n-> ");

            for (Train train : trains) {
                if (trainNumberCurrent == train.getNumber()) {

                    System.out.printf(TRAIN_INFORMATION, train.getNumber(), train.getDestination(), train.getDepartureTime());
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Номер поезда не зарегистрирован.");
            }
        }
    }

    public static void processCommand(ScheduleCommand command, Train[] trains) {

        if (command == SHOW_TRAIN_INFORMATION) {
            showTrainInformation(trains);
        }
        if (command == SHOW_SCHEDULE) {
            showTrainSchedule(trains, getNameOfSchedule(command));
        }
        if (sortingCommands.contains(command)) {
            Arrays.sort(trains, new SortType(command));
            showTrainSchedule(trains, getNameOfSchedule(command));
        }
    }

    public static String getNameOfSchedule(ScheduleCommand command) {

        switch (command) {

            case SHOW_SCHEDULE -> {return "Исходное расписание:\n---------------------------\n";}
            case SORT_SCHEDULE_NUMBER -> {return "Осортированное рассписание по номерам поездов:\n----------------------------------\n";}
            case SORT_SCHEDULE_DESTINATION -> {return "Осортированное рассписание пункту назначения:\n----------------------------------\n";}
            case SORT_SCHEDULE_DEPARTURE_TIME -> {return "Осортированное рассписание по времени отправления:\n----------------------------------\n";}
            case SORT_SCHEDULE_DEPARTURE_AND_TIME -> {return "Осортированное рассписание месту прибытия и времени отправления:\n----------------------------------\n";}
        }
        return null;
    }

    public static void enterOptionsSchedule (){

        System.out.printf("Введите -%d- чтобы вывести расписание поездов \n", SHOW_SCHEDULE.getCode());
        System.out.printf("Введите -%d- чтобы отсортировать  расписание по номеру поезда \n", SORT_SCHEDULE_NUMBER.getCode());
        System.out.printf("Введите -%d- чтобы отсортировать  расписание по месту назначения \n", SORT_SCHEDULE_DESTINATION.getCode());
        System.out.printf("Введите -%d- чтобы отсортировать  расписание по времени прибыти \n", SORT_SCHEDULE_DEPARTURE_TIME.getCode());
        System.out.printf("Введите -%d- чтобы отсортировать  расписание по месту назначения и времени прибытия \n", SORT_SCHEDULE_DEPARTURE_AND_TIME.getCode());
        System.out.printf("Введите -%d- чтобы вывести информацию о поезде \n", SHOW_TRAIN_INFORMATION.getCode());
        System.out.printf("Введите -%d- чтобы завершить программу \n", EXIT_PROGRAM.getCode());
    }
}





















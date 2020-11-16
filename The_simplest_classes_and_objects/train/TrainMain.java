package com.androsor.prog_class.train;


import java.io.IOException;
import java.util.Scanner;

import static com.androsor.prog_class.train.ReadSchedule.*;
import static com.androsor.prog_class.train.SortingScheduleUtil.*;
import static com.androsor.prog_class.train.TypeSortingSchedule.*;


/**
 * Create a Train class containing fields: destination name, train number, departure time. Create data into an array of
 * five elements of the Train type, add the ability to sort the array elements by train numbers.
 * Add the ability to display information about the train, the number of which is entered by the user.
 * Add the ability to sort the array by destination, with trains with the same destination sorted by departure time.
 */

public class TrainMain {


    public static void main(String[] args) throws IOException {

        Train[] trainList = readSchedule();
        enterOptionsSchedule();

        int command;

        do {
            command = enterFromConsole("Введите команду:\n-> ");
            showOptionsSchedule(command, trainList);
        } while (command != EXIT_PROGRAM);

    }

    public static void showTrainSchedule(Train[] trains, String nameOfSchedule) {

        System.out.print(nameOfSchedule);
        for (Train train : trains) {
            System.out.printf(TRAIN_INFORMATION, train.getNumber(), train.getDestination(), train.getDepartureTime());
        }
        System.out.println("----------------------------------");
    }

    public static int enterFromConsole(String massage) {

        System.out.println(massage);
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

    public static void showOptionsSchedule(int command, Train[] trainList) {

        String nameOfSchedule;

        switch (command) {

            case SHOW_SCHEDULE -> {
                nameOfSchedule = "Исходное расписание:\n---------------------------\n";
                showTrainSchedule(trainList, nameOfSchedule);
            }
            case SORT_SCHEDULE_NUMBER -> {
                sortByNumber(trainList);
                nameOfSchedule = "Осортированное рассписание по номерам поездов:\n----------------------------------\n";
                showTrainSchedule(trainList, nameOfSchedule);
            }
            case SORT_SCHEDULE_DESTINATION -> {
                sortByDestination(trainList);
                nameOfSchedule = "Осортированное рассписание пункту назначения:\n----------------------------------\n";
                showTrainSchedule(trainList, nameOfSchedule);
            }
            case SORT_SCHEDULE_DEPARTURE_TIME -> {
                sortByDepartureTime(trainList);
                nameOfSchedule = "Осортированное рассписание по времени отправления:\n----------------------------------\n";
                showTrainSchedule(trainList, nameOfSchedule);
            }
            case SORT_SCHEDULE_DEPARTURE_AND_TIME -> {
                sortByTrainDestinationAndDepartureTime(trainList);
                nameOfSchedule = "Осортированное рассписание месту прибытия и времени отправления:" +
                        "\n----------------------------------\n";
                showTrainSchedule(trainList, nameOfSchedule);
            }
            case SHOW_TRAIN_INFORMATION -> showTrainInformation(trainList);

            case EXIT_PROGRAM -> {
            }
            default -> System.out.print("Неверная команда. ");
        }
    }

    public static void enterOptionsSchedule (){
        System.out.printf("Введите -%d- чтобы вывести расписание поездов \n", SHOW_SCHEDULE);
        System.out.printf("Введите -%d- чтобы отсортировать  расписание по номеру поезда \n", SORT_SCHEDULE_NUMBER);
        System.out.printf("Введите -%d- чтобы отсортировать  расписание по месту назначения \n", SORT_SCHEDULE_DESTINATION);
        System.out.printf("Введите -%d- чтобы отсортировать  расписание по времени прибыти \n", SORT_SCHEDULE_DEPARTURE_TIME);
        System.out.printf("Введите -%d- чтобы отсортировать  расписание по месту назначения и времени прибытия \n", SORT_SCHEDULE_DEPARTURE_AND_TIME);
        System.out.printf("Введите -%d- чтобы вывести информацию о поезде \n", SHOW_TRAIN_INFORMATION);
        System.out.printf("Введите -%d- чтобы завершить программу \n", EXIT_PROGRAM);
    }
}





















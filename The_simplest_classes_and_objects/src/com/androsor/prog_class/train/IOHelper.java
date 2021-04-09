package com.androsor.prog_class.train;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import static com.androsor.prog_class.train.ScheduleCommand.*;

public class IOHelper {

    public static int enterFromConsoleInt(String massage) {
        System.out.print(massage);
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.print("Введенное значение не является числом. Повторите ввод:\n-> ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void enterOptionsSchedule () {
        for (ScheduleCommand scheduleCommand : values()) {
            System.out.printf("-%d- %s\n", scheduleCommand.getCode(), scheduleCommand.getDescription() );
        }
    }

    public static void printTrainInformation(Train train) {
        System.out.printf(" Поезд №-%s\t\t%s\t\t%s\n", train.getNumber(), train.getDestination(), train.getDepartureTime());
    }

    public static void showTrainInformation(List<Train> trains) {
        int trainNumberCurrent = enterFromConsoleInt("Введите номер позда:\n-> ");
        Optional<Train> train = trains.stream().filter(tr -> tr.getNumber() == trainNumberCurrent).findAny();
        if (train.isPresent()) {
            printTrainInformation(train.get());
        } else {
            System.out.println("Номер поезда не зарегистрирован.");
        }
    }

    public static void showTrainSchedule(List<Train> trains, String nameOfSchedule) {
        System.out.printf("%s\n", nameOfSchedule);
        trains.forEach(IOHelper::printTrainInformation);
        System.out.println("----------------------------------");
    }

    public static List<Train> readSchedule()  {
        List<Train> trains = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/com/androsor/prog_class/train/Trine.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split("\\s");
                trains.add(new Train(Integer.parseInt(lines[0]), lines[1], lines[2]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return trains;
    }
}

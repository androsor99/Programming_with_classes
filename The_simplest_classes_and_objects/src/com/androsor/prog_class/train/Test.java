package com.androsor.prog_class.train;

import java.util.ArrayList;
import java.util.List;

import static com.androsor.prog_class.train.IOHelper.enterFromConsoleInt;
import static com.androsor.prog_class.train.IOHelper.enterOptionsSchedule;
import static com.androsor.prog_class.train.IOHelper.readSchedule;
import static com.androsor.prog_class.train.IOHelper.showTrainSchedule;
import static com.androsor.prog_class.train.IOHelper.showTrainInformation;
import static com.androsor.prog_class.train.ScheduleCommand.*;

/**
 * Create a Train class containing fields: destination name, train number, departure time. Create data into an array of
 * five elements of the Train type, add the ability to sort the array elements by train numbers.
 * Add the ability to display information about the train, the number of which is entered by the user.
 * Add the ability to sort the array by destination, with trains with the same destination sorted by departure time.
 */
public class Test {

    private static final String INPUT_MESSAGE = "Введите команду:\n-> ";
    private static final String INVALID_COMMAND_MESSAGE = "Неверная команда.";

    public static void main(String[] args) {
        List<Train> trains = readSchedule();
        enterOptionsSchedule();

        while (true) {
            int userCommand = enterFromConsoleInt(INPUT_MESSAGE);
            ScheduleCommand command = getScheduleCommandByCode(userCommand);
            processCommand(command, trains);
        }
    }

    public static void processCommand(ScheduleCommand command, List<Train> trains) {
        List<Train> processedTrains = new ArrayList<>(trains);
        if (command == SHOW_SCHEDULE) {
            showTrainSchedule(trains, command.getDescription());
        }
        if (sortingCommands.contains(command)) {
            processedTrains.sort(new SortingType(command));
            showTrainSchedule(processedTrains, command.getDescription());
        }
        if (command == SHOW_TRAIN_INFORMATION) {
            showTrainInformation(trains);
        }
        if (command == EXIT_PROGRAM) {
            System.exit(EXIT_PROGRAM.getCode());
        } else if (command == null) {
            System.out.print(INVALID_COMMAND_MESSAGE);
        }
    }
}

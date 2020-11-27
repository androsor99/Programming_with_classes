package com.androsor.prog_class.train;

import java.util.Arrays;
import java.util.List;

public enum ScheduleCommand {

    SHOW_SCHEDULE(0),
    SORT_SCHEDULE_NUMBER(1),
    SORT_SCHEDULE_DESTINATION(2),
    SORT_SCHEDULE_DEPARTURE_TIME(3),
    SORT_SCHEDULE_DEPARTURE_AND_TIME(4),
    SHOW_TRAIN_INFORMATION(5),
    EXIT_PROGRAM(6);

    private final int code;
    public static List<ScheduleCommand> sortingCommands = Arrays.asList(SORT_SCHEDULE_NUMBER, SORT_SCHEDULE_DESTINATION, SORT_SCHEDULE_DEPARTURE_TIME, SORT_SCHEDULE_DEPARTURE_AND_TIME);

    ScheduleCommand(int code) { this.code = code; }

    public int getCode() {
        return code;
    }

    public static ScheduleCommand getScheduleCommandByCode(int code) {

        for (ScheduleCommand command : ScheduleCommand.values()) {
            if (command.getCode() == code) {
                return command;
            }
        }
        return null;
    }
}

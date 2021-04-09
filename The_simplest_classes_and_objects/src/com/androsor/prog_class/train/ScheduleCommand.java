package com.androsor.prog_class.train;

import java.util.Arrays;
import java.util.List;

public enum ScheduleCommand {

    SHOW_SCHEDULE(0, "Исходное расписание."),
    SORT_SCHEDULE_NUMBER(1, "Осортированное рассписание по номерам поездов."),
    SORT_SCHEDULE_DESTINATION(2, "Осортированное рассписание пункту назначения:."),
    SORT_SCHEDULE_DEPARTURE_TIME(3, "Осортированное рассписание по времени отправления:."),
    SORT_SCHEDULE_DEPARTURE_AND_TIME(4, "Осортированное рассписание месту прибытия и времени отправления."),
    SHOW_TRAIN_INFORMATION(5, " Информация о поезде."),
    EXIT_PROGRAM(6, "Выход из программы\n");

    private final int code;
    private final String description;
    public static List<ScheduleCommand> sortingCommands = Arrays.asList(SORT_SCHEDULE_NUMBER, SORT_SCHEDULE_DESTINATION, SORT_SCHEDULE_DEPARTURE_TIME, SORT_SCHEDULE_DEPARTURE_AND_TIME);

    ScheduleCommand(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
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

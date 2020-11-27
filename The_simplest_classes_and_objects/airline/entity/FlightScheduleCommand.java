package com.androsor.prog_class.airline.entity;

public enum FlightScheduleCommand {

    SHOW_FLIGHT_SCHEDULE(0),
    FLIGHT_SCHEDULE_BY_DESTINATION(1),
    FLIGHT_SCHEDULE_BY_DAY_OF_WEEK(2),
    FLIGHT_SCHEDULE_BY_DAY_OF_WEEK_AND_DEPARTURE_TIME(3),
    EXIT_PROGRAM(4);

    private final int code;

    FlightScheduleCommand(int code) { this.code = code; }

    public int getCode() {
        return code;
    }

    public  static FlightScheduleCommand getScheduleCommandByCode(int code) {

        for (FlightScheduleCommand command : FlightScheduleCommand.values()) {
            if (command.getCode() == code) {
                return command;
            }
        }
        return null;
    }
}


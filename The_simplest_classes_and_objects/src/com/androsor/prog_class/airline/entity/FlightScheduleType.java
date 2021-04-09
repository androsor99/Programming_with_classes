package com.androsor.prog_class.airline.entity;

import com.androsor.prog_class.airline.logic.FlightSelection;
import com.androsor.prog_class.airline.logic.FlightSelectionByDaysOfWeekAndTimeImpl;
import com.androsor.prog_class.airline.logic.FlightSelectionByDaysOfWeekImpl;
import com.androsor.prog_class.airline.logic.FlightSelectionByDestinationIImpl;

import java.util.function.Supplier;

public enum FlightScheduleType {

    //SHOW_FLIGHT_SCHEDULE(0),
    FLIGHT_SCHEDULE_BY_DESTINATION(1, FlightSelectionByDestinationIImpl::new),
    FLIGHT_SCHEDULE_BY_DAY_OF_WEEK(2, FlightSelectionByDaysOfWeekImpl::new),
    FLIGHT_SCHEDULE_BY_DAY_OF_WEEK_AND_DEPARTURE_TIME(3, FlightSelectionByDaysOfWeekAndTimeImpl::new);
    //EXIT_PROGRAM(4);

    private final int typeCode;
    private final Supplier<? extends FlightSelection> flightSelection;

    FlightScheduleType(int typeCode, Supplier<? extends FlightSelection> flightSelection) {
        this.typeCode = typeCode;
        this.flightSelection = flightSelection;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public FlightSelection getFlightSelection() {
        return flightSelection.get();
    }

    public static FlightScheduleType getFlightScheduleType(int code) {
        for (FlightScheduleType type : FlightScheduleType.values()) {
            if (type.getTypeCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Нешта здарылася!");
    }
}

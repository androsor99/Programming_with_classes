package com.androsor.prog_class.train;

import java.util.Comparator;
import static com.androsor.prog_class.train.ScheduleCommand.*;

public final class SortType implements Comparator<Train> {

    private final ScheduleCommand command;

    public SortType(ScheduleCommand command) {
        this.command = command;
    }

    @Override
    public int compare(Train o1, Train o2) {
        if (command == SORT_SCHEDULE_NUMBER) {
            return Integer.compare(o1.getNumber(), o2.getNumber());
        }
        if (command == SORT_SCHEDULE_DESTINATION) {
            return o1.getDestination().compareTo(o2.getDestination());
        }
        if (command == SORT_SCHEDULE_DEPARTURE_TIME) {
            return o1.getDepartureTime().compareTo(o2.getDepartureTime());
        }
        if (command == SORT_SCHEDULE_DEPARTURE_AND_TIME) {
            if (o1.getDestination().equals(o2.getDestination())) {
                return o1.getDepartureTime().compareTo(o2.getDepartureTime());
            }
            return o1.getDestination().compareTo(o2.getDestination());
        }
        return 0;
    }


//        switch (command) {
//            case SORT_SCHEDULE_NUMBER -> {
//                return new SortingByNumber();
//            }
//            case SORT_SCHEDULE_DESTINATION -> {
//                return new SortingByDestination();
//            }
//            case SORT_SCHEDULE_DEPARTURE_TIME -> {
//                return new SortingByDepartureTime();
//            }
//            case SORT_SCHEDULE_DEPARTURE_AND_TIME -> {
//                return new SortingByDestinationAndDepartureTime();
//            }
//        }
//        return null;
//    }
}





//
//
//        return  (o1, o2) -> {
////            if (command == SORT_SCHEDULE_NUMBER) {
////                return Integer.compare(o1.getNumber(), o2.getNumber());
////            }
////            if (command == SORT_SCHEDULE_DESTINATION) {
////                return o1.getDestination().compareTo(o2.getDestination());
////            }
////            if (command == SORT_SCHEDULE_DEPARTURE_TIME) {
////                return o1.getDepartureTime().compareTo(o2.getDepartureTime());
////            }
////            if (command == SORT_SCHEDULE_DEPARTURE_AND_TIME) {
////                if (o1.getDestination().equals(o2.getDestination())) {
////                    return o1.getDepartureTime().compareTo(o2.getDepartureTime());
////                }
////                return o1.getDestination().compareTo(o2.getDestination());
////            }
////            return 0;
////        };
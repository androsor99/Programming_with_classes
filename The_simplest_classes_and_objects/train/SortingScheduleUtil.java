package com.androsor.prog_class.train;

import java.util.Arrays;
import java.util.Comparator;

public final class SortingScheduleUtil {

    public static void sortByNumber(Train[] trains) { // сортировка массива по номеру поезда

        Arrays.sort(trains, new Comparator<Train>() {

            @Override
            public int compare(Train o1, Train o2) {
                return Integer.compare(o1.getNumber(), o2.getNumber());
            }
        });
    }

    public static void sortByDestination(Train[] trains) { // сортировка массива по месту назначения

        Arrays.sort(trains, new Comparator<Train>() {

            @Override
            public int compare(Train o1, Train o2) {
                return o1.getDestination().compareTo(o2.getDestination());
            }
        });
    }

    public static void sortByDepartureTime(Train[] trains) { // сортировка массива по времени отправления

        Arrays.sort(trains, new Comparator<Train>() {

            @Override
            public int compare(Train o1, Train o2) {
                return o1.getDepartureTime().compareTo(o2.getDepartureTime());
            }
        });
    }

    public static void sortByTrainDestinationAndDepartureTime(Train [] trains) { // сортировка массива по месту назначения и времени отправления

        Arrays.sort(trains, new Comparator<Train>() {

            @Override
            public int compare(Train o1, Train o2) {
                if (o1.getDestination().equals(o2.getDestination())) {
                    return o1.getDepartureTime().compareTo(o2.getDepartureTime());
                }
                return o1.getDestination().compareTo(o2.getDestination());
            }
        });
    }
}


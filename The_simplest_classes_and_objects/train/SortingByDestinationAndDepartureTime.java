package com.androsor.prog_class.train;

import java.util.Comparator;

public class SortingByDestinationAndDepartureTime implements Comparator<Train> {

    @Override
    public int compare(Train o1, Train o2) {
        if (o1.getDestination().equals(o2.getDestination())) {
            return o1.getDepartureTime().compareTo(o2.getDepartureTime());
        }
        return o1.getDestination().compareTo(o2.getDestination());
    }
}
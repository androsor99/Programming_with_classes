package com.androsor.task5.service;

import com.androsor.task5.entity.Tour;
import com.androsor.task5.entity.TravelAgency;

import java.util.ArrayList;
import java.util.List;

public class TourHandler {

    private TravelAgency travelAgency;

    public TourHandler(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
    }

    public TravelAgency getTravelAgency() {
        return travelAgency;
    }

    public void setTravelAgency(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
    }

    public List<Tour> selectTour(String userSelector, TypeOfTourSelection type) {
        return type.getTypeOfTourSelection().apply(travelAgency.getTours(), userSelector);
    }

    public List<Tour> sortTour(TypeOfTourSorting type) {
        List<Tour> sortedTour = new ArrayList<>(travelAgency.getTours());
        type.getTypeOfTourSorting().accept(sortedTour);
        return sortedTour;
    }
}

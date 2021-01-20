package com.androsor.task4_2_5.logic;

import com.androsor.task4_2_5.entity.*;
import com.androsor.task4_2_5.error.TourException;
import com.androsor.task4_2_5.main.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelAgencyLogic {

    private TravelAgency travelAgency;

    public TravelAgencyLogic(TravelAgency travelAgency) {
        super();
        this.travelAgency = travelAgency;
    }

    public TravelAgency getAgency() {
        return travelAgency;
    }

    public void setAgency(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
    }

    public List<Tour> selectByToursType (String type) throws TourException {
        List<Tour> toursType = new ArrayList<>();
        for (Tour tours : travelAgency.getAllTours()) {
            if (tours.getType().equalsIgnoreCase(type)) {
                toursType.add(tours);
            }
        }
        Validator.chekEnteredParameters(toursType);
        return toursType;
    }

    public List<Tour> selectByToursCountry (String country) throws TourException {
        List<Tour> toursCountry = new ArrayList<>();
        for (Tour tours : travelAgency.getAllTours()) {
            if (tours.filterTourByCountry(country)) {
                toursCountry.add(tours);
            }
        }
        Validator.chekEnteredParameters(toursCountry);
        return toursCountry;
    }

    public List<Tour> selectByToursTransportation (String transport) throws TourException {
        List<Tour> toursTransport = new ArrayList<>();
        for (Tour tours : travelAgency.getAllTours()) {
            if (tours.getTransportation().equalsIgnoreCase(transport)) {
                toursTransport.add(tours);
            }
        }
        Validator.chekEnteredParameters(toursTransport);
        return toursTransport;
    }

    public List<Tour> selectByToursFoodIncluded (TravelAgency travelAgency, boolean isTourIncluded){
        List<Tour> toursFood = new ArrayList<>();
        for (Tour tours : travelAgency.getAllTours()) {
            if (tours.isFood() == isTourIncluded) {
                toursFood.add(tours);
            }
        }
        return toursFood;
    }

    public List<Tour> selectByToursPrice (int price) throws TourException {
        List<Tour> toursPrice = new ArrayList<>();
        for (Tour tours : travelAgency.getAllTours()) {
            if (tours.getPrice() <= price) {
                toursPrice.add(tours);
            }
        }
        Validator.chekEnteredParameters(toursPrice);
        return toursPrice;
    }

    public List<Tour> selectByToursDays (int days) throws TourException {
        List<Tour> toursDays = new ArrayList<>();
        for (Tour tours : travelAgency.getAllTours()) {
            if (tours.getDays() <= days) {
                toursDays.add(tours);
            }
        }
        Validator.chekEnteredParameters(toursDays);
        return toursDays;
    }

    public List<Tour> sortByPrice(List<Tour> tour) {
        tour.sort(Comparator.comparing(Tour::getPrice));
        return tour;
    }

    public List<Tour> sortByDays(List<Tour> tour) {
        tour.sort(Comparator.comparing(Tour::getDays));
        return tour;
    }
}

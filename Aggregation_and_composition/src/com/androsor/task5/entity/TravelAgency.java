package com.androsor.task5.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TravelAgency {

    private String name;
    private List<Tour> tours;

    public TravelAgency() {
        this.tours = new ArrayList<>();
    }

    public TravelAgency(String name) {
        this.name = name;
        this.tours = new ArrayList<>();
    }

    public TravelAgency(String name, List<Tour> tours) {
        this.name = name;
        this.tours = tours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void addTours(List<Tour> tours) {
        this.tours = tours;
    }

    public void addTour(Tour tour) {
        this.tours.add(tour);
    }

    public void deleteTours(List<Tour> tours) {
        this.tours.removeAll(tours);
    }

    public void deleteTour(Tour tour) {
        this.tours.remove(tour);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelAgency that = (TravelAgency) o;
        return Objects.equals(name, that.name) && Objects.equals(tours, that.tours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tours);
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "name='" + name + '\'' +
                ", allTours=" + tours +
                '}';
    }
}

package com.androsor.prog_class.airline.entity;

import java.util.List;
import java.util.Objects;

public class Airline {
    private String destination;
    private String flightNumber;
    private String planeType;
    private String departureTime;
    private List<String> dayOfWeeks;

    public Airline(String destination, String flightNumber, String planeType, String departureTime, List<String> dayOfWeeks) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departureTime = departureTime;
        this.dayOfWeeks = dayOfWeeks;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public List<String> getDayOfWeeks() {
        return dayOfWeeks;
    }

    public void setDayOfWeeks(List<String> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(destination, airline.destination)
                && Objects.equals(flightNumber, airline.flightNumber)
                && Objects.equals(planeType, airline.planeType)
                && Objects.equals(departureTime, airline.departureTime)
                && Objects.equals(dayOfWeeks, airline.dayOfWeeks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, flightNumber, planeType, departureTime, dayOfWeeks);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        dayOfWeeks.forEach(dayOfWeek -> strBuilder.append(dayOfWeek).append(", "));
        return String.format("Рейс #: %s; Направление: %s; Самолёт: %s; Вылет: %s; День недели: %s\b\b.",
                flightNumber, destination,  planeType, departureTime, strBuilder.toString());
    }
}


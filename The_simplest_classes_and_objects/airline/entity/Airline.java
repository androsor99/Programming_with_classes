package com.androsor.prog_class.airline.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Airline {
    private String destination;
    private String flightNumber;
    private String planeType;
    private Date departureTime;
    private String[] dayOfWeek;

    public static SimpleDateFormat ft = new SimpleDateFormat("HH:mm");

    public Airline(String destination, String flightNumber, String planeType, Date departureTime, String[] dayOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departureTime = departureTime;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (String day : dayOfWeek) {
            strBuilder.append(day);
            strBuilder.append(", ");
        }
        return String.format("Рейс #: %s; Направление: %s; Самолёт: %s; Вылет: %s; День недели: %s\b\b.\n",
                flightNumber, destination,  planeType, ft.format(departureTime), strBuilder.toString());
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String[] getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String[] dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}





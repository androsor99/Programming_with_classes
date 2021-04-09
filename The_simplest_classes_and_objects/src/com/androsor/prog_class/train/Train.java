package com.androsor.prog_class.train;

import java.util.Objects;

class Train {

    private final int number;
    private final String destination;
    private final String departureTime;

    public Train(int trainNumber, String destination, String departureTime) {
        this.number = trainNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public int getNumber() {
        return number;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return number == train.number && Objects.equals(destination, train.destination) && Objects.equals(departureTime, train.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, destination, departureTime);
    }

    @Override
    public String toString() {
        return "Train{" +
                "Number=" + number +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}

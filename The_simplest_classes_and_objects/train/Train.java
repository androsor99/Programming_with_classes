package com.androsor.prog_class.train;

class Train {
    private int Number;
    private String destination;
    private String departureTime;

    public Train(int trainNumber, String destination, String departureTime) {
        this.Number = trainNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int trainNumber) {
        this.Number = trainNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}




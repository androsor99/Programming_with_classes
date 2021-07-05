package com.androsor.task5.entity;

public enum TransportType {

    DEFAULT("На оленях"),
    PLANE("Самолёт"),
    BUS("Автобс"),
    TRAIN("Поезд"),
    SHIP("Карабль");

    private final String type;

    TransportType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

package com.androsor.task2.logic;

import com.androsor.task2.entity.Wheel;

public enum CarWheels {

    FRONT_LEFT_WHEEL("Передняя левая", new Wheel()),
    FRONT_RIGHT_WHEEL("Передняя правая", new Wheel()),
    BACK_LEFT_WHEEL("Задняя левая", new Wheel()),
    BACK_RIGHT_WHEEL("Задняя правая", new Wheel());

    private final String position;
    private Wheel wheel;

    CarWheels(String position, Wheel wheel) {
        this.position = position;
        this.wheel = wheel;
    }

    public String getPosition() {
        return position;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}

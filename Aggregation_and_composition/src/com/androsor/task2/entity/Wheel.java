package com.androsor.task2.entity;

import java.util.Objects;

public class Wheel {

    private boolean isWornOut;

    public Wheel() {
    }

    public boolean isWornOut() {
        return isWornOut;
    }

    public void setWornOut(boolean wornOut) {
        isWornOut = wornOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return isWornOut == wheel.isWornOut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWornOut);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Шина ").append(isWornOut ? "резя дай Бог каждому" : "изношена").append(".");
        return stringBuilder.toString();
    }
}

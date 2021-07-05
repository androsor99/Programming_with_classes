package com.androsor.task2.entity;

import java.util.Objects;

public class Engine {

    private boolean isRunning;

    public Engine() {
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return isRunning == engine.isRunning;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRunning);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Двигатель ").append(isRunning ? "запущен" : "заглушен").append(".");
        return stringBuilder.toString();
    }
}

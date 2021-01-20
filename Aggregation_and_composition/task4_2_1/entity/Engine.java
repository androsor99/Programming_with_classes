package com.androsor.task4_2_1.entity;

public class Engine {

    private double power;
    private double fuelConsumption;
    private double resourceOil = 7000;
    private boolean isStarted;

    public Engine() {
        power = 120;
        fuelConsumption = 8.5;
        isStarted = false;
    }

    public Engine(double power, double fuelConsumption) {
        this. power = power;
        this.fuelConsumption = fuelConsumption;
        isStarted = false;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getResourceOil() {
        return resourceOil;
    }

    public void setResourceOil(double resourceOil) {
        this.resourceOil = resourceOil;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public String infoEngine() {
        return String.format("Мощность двигателя -> %.2f л.c.\nРасход топлива -> %.2f л./100 км.\nОставшейся ресурс моторного масла -> %.2f км.\nСостояние -> %s",
                power, fuelConsumption, resourceOil, (isStarted ? "Двигатель запущен" : "Двигатель заглушен"));
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power=" + power +
                ", fuelConsumption=" + fuelConsumption +
                ", resourceOil=" + resourceOil +
                ", isStarted=" + isStarted +
                '}';
    }
}




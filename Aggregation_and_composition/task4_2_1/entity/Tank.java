package com.androsor.task4_2_1.entity;

public class Tank {

    private double volume;
    private double volumeFuel;


    public Tank() {
        volume = 60;
        volumeFuel = 0;
    }

    public Tank(double volume, double volumeFuel) {
        this.volume = volume;
        this.volumeFuel = volumeFuel;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolumeFuel() {
        return volumeFuel;
    }

    public void setVolumeFuel(double volumeFuel) {
        this.volumeFuel = volumeFuel;
    }

    public String infoTank() {
        return String.format("Топлива в баке -> %.2f л. / Объём бака -> %.2f л.", volumeFuel, volume);
    }

    @Override
    public String toString() {
        return "Tank{" +
                "volume=" + volume +
                ", volumeFuel=" + volumeFuel +
                '}';
    }
}


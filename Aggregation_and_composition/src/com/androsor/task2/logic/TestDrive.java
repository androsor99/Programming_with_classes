package com.androsor.task2.logic;

import com.androsor.task2.entity.Car;

public class TestDrive implements CarCondition, CarService {

    private Car car;

    public TestDrive(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

package com.androsor.task2.logic;

import com.androsor.task2.entity.Car;

public interface CarCondition {

    default void start(Car car) {
        if (!car.isFueled()) {
            System.out.println("Наадо заправиться!");
        } else if (!car.getEngine().isRunning() && car.isFueled()) {
            car.getEngine().setRunning(true);
            System.out.println(car.getEngine().toString());
        } else System.out.println(car.getEngine().toString());
    }

    default void stop(Car car) {
        if (car.getEngine().isRunning()) {
            car.getEngine().setRunning(false);
        }
        System.out.println(car.getEngine().toString());
    }

    default void refuel(Car car) {
        car.setFuel(true);
        System.out.println("Авто заправлен");
    }

    default void drive(Car car) {
        start(car);
        if (!car.getEngine().isRunning()) {
            System.out.println(car.getEngine().toString() + "НИПАЕДУ!");
        } else {
            System.out.println(car.getEngine().toString() + "Автос заправлен. Попёрли!");
        }
    }
}

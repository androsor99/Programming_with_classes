package com.androsor.task2.logic;

import com.androsor.task2.entity.Car;

public interface CarService {

    default void replaceWheel(Car car) {
        for (CarWheels wheel : car.getWheels()) {
            if (!wheel.getWheel().isWornOut()) {
                wheel.getWheel().setWornOut(true);
                System.out.println(wheel.getPosition() + " шина заменена.");
            }
        }
    }
}

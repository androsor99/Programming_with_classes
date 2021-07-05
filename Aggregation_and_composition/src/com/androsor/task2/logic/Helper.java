package com.androsor.task2.logic;

import com.androsor.task2.entity.Car;
import com.androsor.task2.entity.Wheel;

import java.util.Random;

public class Helper {

    public static void getCarWithRandomTireWornOut(Car car) {
        Random random = new Random();
        for (CarWheels wheel : car.getWheels()) {
            Wheel wheelRandom = new Wheel();
            wheelRandom.setWornOut(random.nextBoolean());
            wheel.setWheel(wheelRandom);
        }
    }
}

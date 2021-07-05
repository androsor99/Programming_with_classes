package com.androsor.task2.main;

import com.androsor.task2.entity.Car;
import com.androsor.task2.logic.TestDrive;

import static com.androsor.task2.logic.Helper.getCarWithRandomTireWornOut;

/**
 * Create an object of the Car class using the Wheel and Engine classes. Methods: driving, refueling, changing a wheel,
 * displaying the make of the car on the console.
 */
public class Test {

    public static void main(String[] args) {
        Car car = new Car("BMW", "X10");
        TestDrive testDrive = new TestDrive(car);
        getCarWithRandomTireWornOut(car);
        System.out.println(car);

        testDrive.replaceWheel(car);
        System.out.println(car);

        testDrive.drive(car);
        testDrive.refuel(car);
        testDrive.drive(car);
        testDrive.stop(car);
    }
}

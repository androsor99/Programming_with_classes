package com.androsor.task2.entity;

import com.androsor.task2.logic.CarWheels;

import java.util.Arrays;
import java.util.Objects;


public class Car {

    private String carBrand;
    private String model;
    private Engine engine;
    private CarWheels[] wheels;

    private boolean isFueled;

    public Car(String carBrand, String model) {
        this.carBrand = carBrand;
        this.model = model;
        this.engine = new Engine();
        this.wheels = CarWheels.values();
        this.isFueled = false;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarWheels[] getWheels() {
        return wheels;
    }

    public void setWheels(CarWheels[] wheels) {
        this.wheels = wheels;
    }

    public boolean isFueled() {
        return isFueled;
    }

    public void setFuel(boolean fueled) {
        isFueled = fueled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isFueled == car.isFueled && Objects.equals(carBrand, car.carBrand) && Objects.equals(model, car.model)
                && Objects.equals(engine, car.engine) && Arrays.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(carBrand, model, engine, isFueled);
        result = 31 * result + Arrays.hashCode(wheels);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Автомобиль:\n");
        stringBuilder.append("Марка: ").append(carBrand).append("\n");
        stringBuilder.append("Модель: ").append(model).append("\n");
        stringBuilder.append("Шины:\n");
        for (CarWheels carWheel : wheels) {
            stringBuilder.append(carWheel.getPosition()).append(" - ").append(carWheel.getWheel()).append("\n");
        }
        stringBuilder.append("Уровень топлива: ").append(isFueled ? "Заправлен" : "Подкинь брикету").append(".");
        return stringBuilder.toString();
    }
}

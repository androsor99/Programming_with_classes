package com.androsor.task4_2_1.entity;

public class Car {

    private String carBrand;
    private String model;
    private int mileage;
    private Engine engine;
    private Tank tank;
    private Wheel frontLeft;
    private Wheel frontRight;
    private Wheel backLeft;
    private Wheel backRight;

    public Car() {
        this.engine = new Engine();
        this.tank = new Tank();
        this.frontLeft = new Wheel();
        this.frontRight = new Wheel();
        this.backLeft = new Wheel();
        this.backRight = new Wheel();
        this.mileage = 0;
    }

    public Car(String carBrand, String model, Engine engine) {
        this();
        this.carBrand = carBrand;
        this.model = model;
        this.engine = engine;
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

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Wheel getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(Wheel frontLeft) {
        this.frontLeft = frontLeft;
    }

    public Wheel getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(Wheel frontRight) {
        this.frontRight = frontRight;
    }

    public Wheel getBackLeft() {
        return backLeft;
    }

    public void setBackLeft(Wheel backLeft) {
        this.backLeft = backLeft;
    }

    public Wheel getBackRight() {
        return backRight;
    }

    public void setBackRight(Wheel backRight) {
        this.backRight = backRight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", engine=" + engine +
                ", tank=" + tank +
                ", frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", backLeft=" + backLeft +
                ", backRight=" + backRight +
                '}';
    }
}


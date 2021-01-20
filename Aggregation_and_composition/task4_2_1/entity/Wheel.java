package com.androsor.task4_2_1.entity;
public class Wheel {

    private String brand;
    private int radius;
    private double resource;

    public Wheel() {
        brand = "Китайский китай";
        radius = 17;
        resource = Math.random()*100 + 300;
    }

    public Wheel(String brand, int radius) {
        this.brand = brand;
        this.radius = radius;
        this.resource = Math.random()*100 + 300;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getResource() {
        return resource;
    }

    public void setResource(double resource) {
        this.resource = resource;
    }

    public String infoTire() {
        return String.format("Марка шин -> \"%s\"\nРадиус шин -> R-%d\nОставшейся ресурс -> %.2f км.", brand, radius, resource);
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "brand='" + brand + '\'' +
                ", radius=" + radius +
                ", resource=" + resource +
                '}';
    }
}

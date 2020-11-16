package com.androsor.prog_class.test2;

public class Test2 {

    private double height;
    private String name;

    public Test2(double height, String name) {
        this.height = height;
        this.name = name;
    }

    public Test2() {
        this.height = 100;
        this.name = "Бабирука";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return this.height;
    }

    public String getName() {
        return this.name;
    }
}

package com.androsor.prog_class.test2;

import java.util.Objects;

public class Test2 {

    private double height;
    private String name;

    public Test2() {
        this.height = 100;
        this.name = "Бабирука";
    }

    public Test2(double height, String name) {
        this.height = height;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test2 test2 = (Test2) o;
        return Double.compare(test2.height, height) == 0 && Objects.equals(name, test2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, name);
    }

    @Override
    public String toString() {
        return "Test2{" +
                "height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}

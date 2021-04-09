package com.androsor.prog_class.test1;

import java.util.Objects;

import static java.lang.Math.max;

public class Test1 {

    private double numberOne;
    private double numberTwo;

    public Test1(double numberOne, double numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public double getNumberOne() {
        return numberOne;
    }

    public double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberOne(double numberOne) {
        this.numberOne = numberOne;
    }

    public void setNumberTwo(double numberTwo) {
        this.numberTwo = numberTwo;
    }

    public double getSumNumber() {
       return (numberOne + numberTwo);
    }

    public double getMaxNumber() {
        if (numberOne == numberTwo) {
            return numberOne;
        }
        return max(numberOne, numberTwo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test1 test1 = (Test1) o;
        return Double.compare(test1.numberOne, numberOne) == 0 && Double.compare(test1.numberTwo, numberTwo) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOne, numberTwo);
    }

    @Override
    public String toString() {
        return "Test1{" +
                "numberOne=" + numberOne +
                ", numberTwo=" + numberTwo +
                '}';
    }
}

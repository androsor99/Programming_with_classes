package com.androsor.prog_class.triangle;

import java.util.Objects;

public class ApexTriangle {

   private double coordinate_X;
   private double coordinate_Y;

    public ApexTriangle() {
    }

    public ApexTriangle(double coordinate_X, double coordinate_Y) {
        this.coordinate_X = coordinate_X;
        this.coordinate_Y = coordinate_Y;
    }

    public ApexTriangle(double[] coordinates) {
        this.coordinate_X = coordinates[0];
        this.coordinate_Y = coordinates[1];
    }

    public double getCoordinate_X() {
        return coordinate_X;
    }

    public void setCoordinate_X(double coordinate_X) {
        this.coordinate_X = coordinate_X;
    }

    public double getCoordinate_Y() {
        return coordinate_Y;
    }

    public void setCoordinate_Y(double coordinate_Y) {
        this.coordinate_Y = coordinate_Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApexTriangle that = (ApexTriangle) o;
        return Double.compare(that.coordinate_X, coordinate_X) == 0 &&
                Double.compare(that.coordinate_Y, coordinate_Y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate_X, coordinate_Y);
    }

    @Override
    public String toString() {
        return String.format("[%.2f ; %.2f]", coordinate_X, coordinate_Y);
    }
}

package com.androsor.prog_class.triangle;

import java.util.Objects;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Triangle {

    private ApexTriangle apexA;
    private ApexTriangle apexB;
    private ApexTriangle apexC;

    public Triangle(ApexTriangle apexA, ApexTriangle apexB, ApexTriangle apexC) throws HrenPoymiExсeption {
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
        if (!isTriangleExist()) {
            throw new HrenPoymiExсeption("Треугольник не существует! Точки вершин лежат на одной прямой!");
        }
    }

    public ApexTriangle getApexA() {
        return apexA;
    }

    public void setApexA(ApexTriangle apexA) {
        this.apexA = apexA;
    }

    public ApexTriangle getApexB() {
        return apexB;
    }

    public void setApexB(ApexTriangle apexB) {
        this.apexB = apexB;
    }

    public ApexTriangle getApexC() {
        return apexC;
    }

    public void setApexC(ApexTriangle apexC) {
        this.apexC = apexC;
    }

    private boolean isTriangleExist() {
        double side_AB = calculateSide(apexA, apexB);
        double side_AC = calculateSide(apexA, apexC);
        double side_BC = calculateSide(apexB, apexC);
        return ((side_AB + side_BC) > side_AC) && ((side_AB + side_AC) > side_BC) && ((side_BC + side_AC) > side_AB);
    }

    public double calculateSide(ApexTriangle apexOne, ApexTriangle apexTwo) {
        return sqrt(pow((apexOne.getCoordinate_X() - apexTwo.getCoordinate_X()), 2) +
                pow((apexOne.getCoordinate_Y() - apexTwo.getCoordinate_Y()), 2));
    }

    public double calculatePerimeter() {
        double side_AB = calculateSide(apexA, apexB);
        double side_AC = calculateSide(apexA, apexC);
        double side_BC = calculateSide(apexB, apexC);
        return side_AB + side_BC + side_AC;
    }

    public double calculateSquare() {
        double halfPerimeter = calculatePerimeter() / 2;
        return sqrt(halfPerimeter * (halfPerimeter - calculateSide(apexA, apexB)) *
                (halfPerimeter - calculateSide(apexB, apexC)) * (halfPerimeter - calculateSide(apexA, apexC)));
    }

    public ApexTriangle calculatePointOfMedianCross() {
        double x = (apexA.getCoordinate_X() + apexB.getCoordinate_X() + apexC.getCoordinate_X())/3;
        double y = (apexA.getCoordinate_Y() + apexB.getCoordinate_Y() + apexC.getCoordinate_Y())/3;
        return new ApexTriangle(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(apexA, triangle.apexA) &&
                Objects.equals(apexB, triangle.apexB) &&
                Objects.equals(apexC, triangle.apexC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apexA, apexB, apexC);
    }

    @Override
    public String toString() {
        return String.format("{A%s, B%s, C%s}", apexA, apexB, apexC);
    }
}





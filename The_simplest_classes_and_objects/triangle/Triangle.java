package com.androsor.prog_class.triangle;

import java.util.Objects;

public class Triangle {

    private Coordinate apexOfTriangleA;
    private Coordinate apexOfTriangleB;
    private Coordinate apexOfTriangleC;

    public Triangle(Coordinate apexOfTriangleA, Coordinate apexOfTriangleB, Coordinate apexOfTriangleC) throws HrenPoymiExсeption {

        this.apexOfTriangleA = apexOfTriangleA;
        this.apexOfTriangleB = apexOfTriangleB;
        this.apexOfTriangleC = apexOfTriangleC;

        if (!canTriangleExist(this.apexOfTriangleA, this.apexOfTriangleB, this.apexOfTriangleC)) {
            throw new HrenPoymiExсeption("Треугольник не существует! Точки вершин лежат на одной прямой!");
        }
    }

    public Coordinate getApexOfTriangleA() {
        return apexOfTriangleA;
    }

    public void setApexOfTriangleA(Coordinate apexOfTriangleA) {
        this.apexOfTriangleA = apexOfTriangleA;
    }

    public Coordinate getApexOfTriangleB() {
        return apexOfTriangleB;
    }

    public void setApexOfTriangleB(Coordinate apexOfTriangleB) {
        this.apexOfTriangleB = apexOfTriangleB;
    }

    public Coordinate getApexOfTriangleC() {
        return apexOfTriangleC;
    }

    public void setApexOfTriangleC(Coordinate apexOfTriangleC) {
        this.apexOfTriangleC = apexOfTriangleC;
    }

    private boolean canTriangleExist(Coordinate apexOfTriangleA, Coordinate apexOfTriangleB, Coordinate apexOfTriangleC) {
//        return (apexOfTriangleC.getCoordinateX() - apexOfTriangleA.getCoordinateX()) /
//                (apexOfTriangleB.getCoordinateX() - apexOfTriangleA.getCoordinateX()) ==
//                (apexOfTriangleC.getCoordinateY() - apexOfTriangleA.getCoordinateY()) /
//                        (apexOfTriangleB.getCoordinateY() - apexOfTriangleA.getCoordinateY());

        double sideAB = calculateSideTriangle(apexOfTriangleA, apexOfTriangleB);
        double sideAC = calculateSideTriangle(apexOfTriangleA, apexOfTriangleC);
        double sideBC = calculateSideTriangle(apexOfTriangleB, apexOfTriangleC);

        return ((sideAB + sideBC) > sideAC) && ((sideAB + sideAC) > sideBC) && ((sideBC + sideAC) > sideAB);
    }

    public double calculateSideTriangle(Coordinate apexOfTriangleOne, Coordinate apexOfTriangleTwo) {

        return Math.sqrt(Math.pow((apexOfTriangleOne.getCoordinateX() - apexOfTriangleTwo.getCoordinateX()), 2) +
                Math.pow((apexOfTriangleOne.getCoordinateY() - apexOfTriangleTwo.getCoordinateY()), 2));
    }

    public double calculatePerimeterOfTriangle() {

        double sideAB = calculateSideTriangle(apexOfTriangleA, apexOfTriangleB);
        double sideAC = calculateSideTriangle(apexOfTriangleA, apexOfTriangleC);
        double sideBC = calculateSideTriangle(apexOfTriangleB, apexOfTriangleC);

        return sideAB + sideBC + sideAC;
    }

    public double calculateSquareOfTriangle() {
        double p = calculatePerimeterOfTriangle() / 2;

        return Math.sqrt(p * (p - calculateSideTriangle(apexOfTriangleA, apexOfTriangleB)) *
                (p - calculateSideTriangle(apexOfTriangleB, apexOfTriangleC)) * (p - calculateSideTriangle(apexOfTriangleA, apexOfTriangleC)));
    }

    public Coordinate calculatePointOfMedianCross() {
        double x = (apexOfTriangleA.getCoordinateX() + apexOfTriangleB.getCoordinateX() + apexOfTriangleC.getCoordinateX())/3;
        double y = (apexOfTriangleA.getCoordinateY() + apexOfTriangleB.getCoordinateY() + apexOfTriangleC.getCoordinateY())/3;

        return new Coordinate(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(apexOfTriangleA, triangle.apexOfTriangleA) &&
                Objects.equals(apexOfTriangleB, triangle.apexOfTriangleB) &&
                Objects.equals(apexOfTriangleC, triangle.apexOfTriangleC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apexOfTriangleA, apexOfTriangleB, apexOfTriangleC);
    }

    @Override
    public String toString() {
        return String.format("{A%s,B%s,C%s}", apexOfTriangleA, apexOfTriangleB, apexOfTriangleC);
    }
}





package com.androsor.prog_class.triangle;

import static com.androsor.prog_class.triangle.IOHelper.getRandomCoordinates;

/**
 * Describe a class that represents a triangle. Provide methods for creating objects, calculating area, perimeter and
 * median intersection points.
 */
public class Test {

    public static void main(String[] args) {
        Triangle triangle = createTriangle();

        System.out.printf("Треугольник с вершинами в координатах %s\n", triangle);

        System.out.printf("Периметр треугольника = %.2f\n", triangle.calculatePerimeter());

        System.out.printf("Площадь треугольника = %.2f\n", triangle.calculateSquare());

        System.out.printf("Коодинаты точки пересечения медиан треугольника = %s\n", triangle.calculatePointOfMedianCross());
    }

    public static Triangle createTriangle() {
        Triangle triangle = null;
        try {
            triangle = new Triangle(new ApexTriangle(getRandomCoordinates()), new ApexTriangle(getRandomCoordinates()), new ApexTriangle(getRandomCoordinates()));
        } catch (HrenPoymiExсeption e) {
            System.out.println(e.getMessage());
        }
        return triangle;
    }
}

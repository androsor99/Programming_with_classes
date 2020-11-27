package com.androsor.prog_class.triangle;

import java.util.Scanner;

/**
 * Describe a class that represents a triangle. Provide methods for creating objects, calculating area, perimeter and
 * median intersection points.
 */

public class TriangleMain {

    public static void main(String [] args) throws HrenPoymiExсeption {

        System.out.println("Введите координаты вершины А треугольника:");
        Coordinate coordinateA = new Coordinate(enterFromConsole("x-> "), enterFromConsole("y-> "));

        System.out.println("Введите координаты вершины B треугольника:");
        Coordinate coordinateB = new Coordinate(enterFromConsole("x-> "), enterFromConsole("y-> "));

        System.out.println("Введите координаты вершины C треугольника:");
        Coordinate coordinateC = new Coordinate(enterFromConsole("x-> "), enterFromConsole("y-> "));

        Triangle triangle = new Triangle(coordinateA, coordinateB, coordinateC);

        System.out.printf("Треугольник с вершинами в координатах %s\n", triangle);

        System.out.printf("Периметр треугольника = %.2f\n", triangle.calculatePerimeterOfTriangle());

        System.out.printf("Площадь треугольника = %.2f\n", triangle.calculateSquareOfTriangle());

        System.out.printf("Коодинаты точки пересечения медиан треугольника = %s\n", triangle.calculatePointOfMedianCross());
    }

    public static double enterFromConsole(String massage) {

        System.out.print(massage);
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            System.out.print("Введенное значение не является числом. Повторите ввод:\n-> ");

            sc.next();
        }
        return sc.nextDouble();
    }
}

package edu.course.lab01;

public class QuadraticEquation {

    private static double computeDiscriminant(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public static String quadratic(double a, double b, double c) {
        if (a == 0.0) {
            return "Уравнение не является квадратным";
        }

        double discriminant = QuadraticEquation.computeDiscriminant(a, b, c);

        if (discriminant < 0.0) {
            return "Вещественных корней нет";
        }


        if (discriminant == 0.0) {
            double x = (-b) / 2 * a;
            return "Корень уравнения: " + x;
        }

        double x1 = (-b - Math.sqrt(discriminant)) / 2 * a;
        double x2 = (-b + Math.sqrt(discriminant)) / 2 * a;
        return "Корни уравнения: \nx1: " + x1 + "\nx2: " + x2;
    }
}

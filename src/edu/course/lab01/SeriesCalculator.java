package edu.course.lab01;

import java.util.ArrayList;

public class SeriesCalculator {
    public static void calculate() {
        double LIMIT = 1e-6;
        ArrayList<Double> numbers = new ArrayList<>();
        for (int n = 2; ; ++n) {
            double result = 1 / (Math.pow(n, 2) + n - 2);
            if (result < LIMIT) break;

            numbers.add(result);
        }

        System.out.println("Сумма: " + numbers.stream().mapToDouble(Double::doubleValue).sum());
        System.out.println("Последний добавленный член ряда: " + numbers.getLast());
        System.out.println("Количество добавленных членов ряда: " + numbers.size());

    }

}

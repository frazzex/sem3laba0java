package edu.course.lab01;

public class Main {
    public static void main(String[] args) {
        String command;
        try {
            command = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Для работы программы необходимо передать хотя бы 1 аргумент");
            return;
        }

        switch (command) {
            case "fizzbuzz":
                FizzBuzz.run();
                return;

            case "reverse":
                String arg;
                try {
                    arg = args[1];
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Необходимо передать текст для разворота!");
                    return;
                }

                System.out.println(TextTasks.reverse(arg));
                return;
            case "quadratic":
                double a, b, c;
                try {
                    a = Double.parseDouble(args[1]);
                    b = Double.parseDouble(args[2]);
                    c = Double.parseDouble(args[3]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Для рассчета корня выражения должны быть переданы 3 аргумента");
                    return;
                }

                System.out.println(QuadraticEquation.quadratic(a, b, c));
                return;

            case "series":
                SeriesCalculator.calculate();
                return;

            case "palindrome":
                String str;
                try {
                    str = args[1];
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Необходимо передать текст для проверки палиндрома!");
                    return;

                }
                Boolean result = TextTasks.palindrome(str);
                System.out.println("Строка `" + str + "`" + (result ? " " : " НЕ ") + "является палиндромом");

        }

    }

}
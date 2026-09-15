public class Task2RealArithmetic {
    public static void run() {
subTask6();
    }

    public static void subTask1() {
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));
    }

    public static void subTask2() {
        double accumulator = 0.0;
        for (int i = 0; i < 10; i++) {
            accumulator += 0.1;
        }
        System.out.println("Итоговое значение: " + accumulator + " | Равно ли оно 10? - " + (accumulator == 1.0));
    }

    public static Boolean subTask3(double a, double b, double epsilon) {
        if (a == b) return true;

        double absA = Math.abs(a);
        double absB = Math.abs(b);
        double diff = Math.abs(a - b);

        double largest = Math.max(absA, absB);
            return diff <= largest * epsilon;
    }

    public static void subTask4() {
        System.out.println("Бесконечность: " + (1.0 / 0.0));
        System.out.println("Отрицательная бесконечность: " + (-1.0 / 0.0));
        System.out.println("Получение NaN: " + (Double.POSITIVE_INFINITY / Double.POSITIVE_INFINITY));
        System.out.println("Сравнение NaN и NaN: " + (Double.NaN == Double.NaN));
    }

    public static void subTask5() {
        System.out.println("(int) 2.7: " + ((int) 2.7));
        System.out.println("(int) -2.7: " + ((int) -2.7));
        System.out.println("Math.round(2.7): " + Math.round(2.7));
        System.out.println("Math.round(-2.7): " + Math.round(-2.7));
        System.out.println("Math.floor(2.7): " + Math.floor(2.7));
        System.out.println("Math.floor(-2.7): " + Math.floor(-2.7));
        System.out.println("Math.ceil(2.7): " + Math.ceil(2.7));
        System.out.println("Math.ceil(-2.7): " + Math.ceil(-2.7));

    }

    public static void subTask6() {
        float floatA = 0.55555F;
        float floatB = 1.44444F;

        double doubleA = 0.55555D;
        double doubleB = 1.44444D;

        System.out.println("Результат деления floatA и floatB: " + (floatA / floatB));
        System.out.println("Результат деления doubleA и doubleB: " + (doubleA / doubleB));

    }



}

public class Task1DataTypes {
    public static void run() {
    subTask3();
    }

    public static void subTask1() {
        System.out.println("Byte max value: " + Byte.MAX_VALUE);
        System.out.println("Short max value: " + Short.MAX_VALUE);
        System.out.println("Int max value: " + Integer.MAX_VALUE);
        System.out.println("Long max value: " + Long.MAX_VALUE);
    }

    public static void subTask2() {
        System.out.println("Integer.MAX_VALUE + 1: " + (Integer.MAX_VALUE + 1));
    }

    public static void subTask3() {
        System.out.println("Integer.MAX_VALUE * 2: " + (Integer.MAX_VALUE * 2));
        System.out.println("Long.MAX_VALUE * 2: " + (Long.MAX_VALUE * 2));

    }

    public static void subTask4() {
        System.out.println("5 / 2 = " + 5 / 2);
        System.out.println("-5 / 2 = " + -5 / 2);
        System.out.println("5 % 2 = " + 5 % 2);
        System.out.println("-5 % 2 = " + -5 % 2);
    }

    public static void subTask5() {
        System.out.println("Результат приведения: " + (int) Long.MAX_VALUE);
    }

    public static void subTask6() {
        char symbol = 'a';
        System.out.println("Символ: " + symbol + " | ледующая буква: " + (symbol + 1));
        System.out.println("Сложение двух символов `a`: " + (symbol + symbol));



    }
}

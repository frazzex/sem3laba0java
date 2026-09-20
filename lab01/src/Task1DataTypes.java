public class Task1DataTypes {
    public static void run() {
        subTask1();
        subTask2();
        subTask3();
        subTask4();
        subTask5();
        subTask6();
        subTask7();
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
        char nextSymbol = (char) (symbol + 1);
        System.out.println("Символ: " + (int) symbol + " - " + symbol);
        System.out.println("Следующий символ: " + (int) nextSymbol + " - " + nextSymbol);
        System.out.print("Сложение символов " + symbol + " и " + nextSymbol + ": " + (symbol + nextSymbol) + " - " + (char) (symbol + nextSymbol));

    }

    public static void subTask7() {
        int number1 = 2_000_000_000;
        int number2 = 1_500_000_000;
        long result = (long) number1 + (long) number2;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) System.out.println("Переполнение!");

    }
}

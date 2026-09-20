import java.util.Arrays;

public class Task7MethodsAndArguments {
    public static void run() {
        int[] arr = Task5OneDimensionalArrays.generateRandomArray();
        print(10);
        print(10.0);
        print("10");
        print(arr);

        System.out.println("\nСумма переданных значений: " + sum(1, 2, 3, 4, 5));

        System.out.println("2 в степени 1: " + pow(2, 1));
        System.out.println("2 в степени 5: " + pow(2, 5));
        System.out.println("2 в степени 0: " + pow(2, 0));
        System.out.println("2 в степени 1 рекурсивно: " + powRecursivity(2, 1));
        System.out.println("2 в степени 5 рекурсивно: " + powRecursivity(2, 5));
        System.out.println("2 в степени 0 рекурсивно: " + powRecursivity(2, 0));

    }

    public static void print(int num) {
        System.out.print("Тип Integer: " + num);
    }

    public static void print(double num) {
        System.out.print("Тип Double: " + num);
    }

    public static void print(String str) {
        System.out.print("Тип String: " + str);
    }

    public static void print(int[] arr) {
        System.out.print("Тип int[]: " + Arrays.toString(arr));
    }

    public static int sum(int... varargs) {
        if (varargs.length == 0) return 0;
        return Arrays.stream(varargs).sum();
    }

    public static int pow(int number, int degree) {
        if (degree == 0) return 1;
        int result = number;
        for (int i = 1; i < degree; i++) {
            result *= number;
        }

        return result;
    }

    public static int powRecursivity(int number, int degree) {
        if (degree == 0) return 1;

        return number * powRecursivity(number, degree - 1);

    }
}

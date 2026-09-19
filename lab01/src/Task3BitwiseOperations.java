public class Task3BitwiseOperations {

    public static void run() {
        subTask3();
    }

    public static void subTask1() {
        int a = 10;
        int b = 15;

        System.out.println("a = " + a + " = " + Integer.toBinaryString(a) + " | b = " + b + " = " + Integer.toBinaryString(b));
        System.out.println("a & b   = " + (a & b));
        System.out.println("a | b   = " + (a | b));
        System.out.println("a ^ b   = " + (a ^ b));
        System.out.println("~a      = " + (~a));
        System.out.println("a << 1  = " + (a << 1));
        System.out.println("a >> 1  = " + (a >> 1));
    }

    public static void subTask2() {
        int negative = -8;

        System.out.println(negative + " >> 2 = " + (negative >> 2));
        System.out.println(negative + " >>> 2 = " + (negative >>> 2));
    }

    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static int countSetBits(int n) {
        int counter = 0;
        while (n != 0) {
            n = n & (n - 1);
            counter++;
        }
        return counter;

    }

    public static void subTask3() {
        System.out.println("4 четное? - " + isEven(4));
        System.out.println("7 четное? - " + isEven(7));

        System.out.println("16 является степенью двойки? - " + isPowerOfTwo(16));
        System.out.println("14 является степенью двойки? - " + isPowerOfTwo(14));

        System.out.println("Количество битов в 700 (" + Integer.toBinaryString(700) + "): " + countSetBits(700));

    }

    public static int[] swap(int[] integers_for_swap) {
        integers_for_swap[0] = integers_for_swap[0] ^ integers_for_swap[1];
        integers_for_swap[1] = integers_for_swap[0] ^ integers_for_swap[1];
        integers_for_swap[0] = integers_for_swap[0] ^ integers_for_swap[1];
        return integers_for_swap;
    }

    public static void subTask4() {
        int[] integers_for_swap = {10, 20};
        System.out.println("a = " + integers_for_swap[0] + " | b = " + integers_for_swap[1]);
        swap(integers_for_swap);
        System.out.println("Результат: a = " + integers_for_swap[0] + " | b = " + integers_for_swap[1]);

    }

}

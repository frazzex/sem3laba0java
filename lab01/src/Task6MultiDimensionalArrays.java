import java.util.Arrays;

public class Task6MultiDimensionalArrays {
    public static void run() {
        int[][] arr = generateRandomMultiDimensionalArray();
        printMultiDimensionalArray(arr);
        int[][] transposedArr = transposeMultiDimensionalArray(arr);
        System.out.println("Транспонирование:");
        printMultiDimensionalArray(transposedArr);

        int[][] arr1 = generateRandomMultiDimensionalArray();
        int[][] arr2 = generateRandomMultiDimensionalArray();
        System.out.println("Перемножение:");
        System.out.println("Массив №1:");
        printMultiDimensionalArray(arr1);
        System.out.println("Массив №2:");
        printMultiDimensionalArray(arr2);
        int[][] arr3 = multiplyMultiDimensionalArrays(arr1, arr2);
        System.out.println("Результат:");
        printMultiDimensionalArray(arr3);


    }

    public static void printMultiDimensionalArray(int[][] arr) {
        for (int[] el : arr) {
            System.out.println(Arrays.toString(el) + '\n');
        }
    }

    public static int[][] generateRandomMultiDimensionalArray() {
        final int ROWS = 4;
        final int COLS = 4;
        int[][] arr = new int[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            arr[i] = Task5OneDimensionalArrays.generateRandomArray(COLS, COLS, -100, 100);
        }
        return arr;
    }

    public static int[][] transposeMultiDimensionalArray(int[][] arr) {
        if (arr.length == 0) return new int[0][0];

        final int ROWS = arr.length;
        final int COLS = arr[0].length;

        int[][] transposedArr = new int[COLS][ROWS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                transposedArr[j][i] = arr[i][j];
            }
        }

        return transposedArr;

    }

    public static int[][] multiplyMultiDimensionalArrays(int[][] firstArr, int[][] secondArr) {
        if (firstArr == null || secondArr == null ||
                firstArr.length == 0 || secondArr.length == 0 ||
                firstArr[0].length == 0 || secondArr[0].length == 0) {

            System.out.println("Ошибка: Один или оба массива пусты или равны null");
            return new int[0][0];
        }

        final int FIRST_ROWS = firstArr.length;
        final int FIRST_COLS = firstArr[0].length;
        final int SECOND_ROWS = secondArr.length;
        final int SECOND_COLS = secondArr[0].length;

        if (FIRST_COLS != SECOND_ROWS) {
            System.out.println("Ошибка согласованности");
            return new int[0][0];
        }

        int[][] resultArr = new int[FIRST_ROWS][SECOND_COLS];

        for (int i = 0; i < FIRST_ROWS; i++) {
            for (int j = 0; j < SECOND_COLS; j++) {
                for (int k = 0; k < FIRST_COLS; k++) {
                    resultArr[i][j] += firstArr[i][k] * secondArr[k][j];
                }
            }
        }

        return resultArr;
    }
}

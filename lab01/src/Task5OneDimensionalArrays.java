import java.util.Arrays;

public class Task5OneDimensionalArrays {

    public static void run() {
        int[] arr = generateRandomArray();
        System.out.println(Arrays.toString(arr));
        System.out.println("Минимальное: " + min(arr));
        System.out.println("Максимальное: " + max(arr));
        System.out.println("Ср. арифметическое: " + getArithmeticMean(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {5, 10, 5, 9};
        int[] arr2 = {5, 10, 5, 9};
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        arrayComparison(arr1, arr2);

    }

    public static int[] generateRandomArray() {
        final int MIN_ELEMENTS_COUNT = 1;
        final int MAX_ELEMENTS_COUNT = 20;

        final int MIN_ELEMENT_VALUE = -100;
        final int MAX_ELEMENT_VALUE = 100;

        return generateRandomArray(MIN_ELEMENTS_COUNT, MAX_ELEMENTS_COUNT, MIN_ELEMENT_VALUE, MAX_ELEMENT_VALUE);
    }

    public static int[] generateRandomArray(int min_elements_count, int max_elements_count, int min_element_value, int max_element_value) {


        int[] arr = new int[(int) (Math.random() * (max_elements_count - min_elements_count + 1) + min_elements_count)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (max_element_value - min_element_value + 1) + min_element_value);
        }

        return arr;

    }

    public static int min(int[] arr) {

        if (arr.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        for (int j : arr) if (j < min) min = j;
        return min;
    }

    public static int max(int[] arr) {

        if (arr.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        for (int j : arr) if (j > max) max = j;
        return max;
    }

    public static double getArithmeticMean(int[] arr) {
        if (arr.length == 0) return 0;

        final int ARR_LENGTH = arr.length;
        double sum = 0.0;
        for (int el : arr) sum += el;

        return sum / ARR_LENGTH;

    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0) return;
        if (low >= high) return;
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;
        while (true) {

            while (left <= right && arr[left] <= pivot) left++;

            while (right >= left && arr[right] >= pivot) right--;

            if (right < left) break;

            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;
        return right;
    }

    public static void arrayComparison(int[] arr1, int[] arr2) {
        System.out.println("arr1 == arr2: " + (arr1 == arr2));
        System.out.println("arr1.equals(arr2): " + (arr1.equals(arr2)));
        System.out.println("Arrays.equals(arr1, arr2): " + (Arrays.equals(arr1, arr2)));

    }

}

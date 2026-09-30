import java.util.*;

public class Task1Collections {

    private static int[] generateArray(int n) {
        return new Random().ints(n, 0, 101).toArray();
    }

    private static List<Integer> convertArrayToList(int[] arr) {
        return Arrays.stream(arr).boxed().toList();
    }

    private static void sortArrayListByASC(ArrayList<Integer> arr) {
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return s1.compareTo(s2);
            }
        });
    }

    private static void shiftArrayToRight(ArrayList<Integer> arr) {
        arr.add(arr.getLast());

        for (int i = arr.size() - 2; i != 0; i--) {
            arr.set(i, arr.get(i - 1));
        }
        arr.set(0, 0);

    }

    private static void shiftArrayToRightByShift(ArrayList<Integer> arr, int shift) {
        for (int i = 0; i < shift; i++) {
            shiftArrayToRight(arr);
        }
    }


    public static void run() {

        int[] arr = generateArray(5);
        System.out.println("Исходный массив:\n" + Arrays.toString(arr));

        List<Integer> list = convertArrayToList(arr);
        System.out.println("Массив типа List:\n" + list);

        ArrayList<Integer> arrayList = new ArrayList<>(list);
        arrayList.add(0);
        arrayList.add(0);
        sortArrayListByASC(arrayList);
        System.out.println("Отсортированный массив:\n" + arrayList);

        Collections.reverse(arrayList);
        System.out.println("Отсортированный в обратном порядке массив:\n" + arrayList);

        Collections.shuffle(arrayList);
        System.out.println("Перемешанный массив:\n" + arrayList);

        shiftArrayToRightByShift(arrayList, 1);
        System.out.println("Сдвинутый массив:\n" + arrayList);

        HashMap<Integer, Integer> counts = new HashMap<>();
        ArrayList<Integer> uniqueElements = new ArrayList<Integer>();
        ArrayList<Integer> duplicateElements = new ArrayList<Integer>();

        for (Integer el : arrayList) {
            counts.put(el, counts.getOrDefault(el, 0) + 1);
        }

        counts.forEach((key, value) -> {
            if (value == 1) {
                uniqueElements.add(key);
            } else {
                duplicateElements.add(key);
            }

        });

        System.out.println("Только уникальные:\n" + uniqueElements);
        System.out.println("Только дублирующиеся:\n" + duplicateElements);

        int[] newArr = new int[arrayList.size()];
        for (int i = 0; i < newArr.length; i++) newArr[i] = arrayList.get(i);
        System.out.println("После преобразования: " + Arrays.toString(newArr));

        System.out.println("Количество вхождений элементов: " + counts);


    }
}

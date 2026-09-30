import java.util.HashMap;
import java.util.Map;

public class Task5Dictionary {

    public static <K, V> Map<V, K> invertMap(Map<K, V> sourceMap) {
        Map<V, K> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : sourceMap.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }

        return invertedMap;
    }

    public static void run() {

        HashMap<String, Integer> fruitsMap = new HashMap<>();
        fruitsMap.put("Яблоко", 5);
        fruitsMap.put("Банан", 2);
        fruitsMap.put("Арбуз", 4);

        System.out.println("Исходный: " + fruitsMap);
        System.out.println("Перевернутый: " + invertMap(fruitsMap));

    }


}

import java.util.*;

public class Task4Words {
    public static void run() {
        String line = "А роза упала на лапу Азора упала нА Лапу";
        String[] words = line.split(" ");
        HashSet<String> uniqueWords = new HashSet<>(List.of(words));
        Iterator<String> it = Arrays.stream(words).toList().iterator();
        HashMap<String, Integer> wordsMap = new HashMap<>();
        while (it.hasNext()) {
            String word = it.next();
            String wordLowerCase = word.toLowerCase();
            wordsMap.put(wordLowerCase, wordsMap.getOrDefault(wordLowerCase, 0) + 1);
        }
        System.out.println("Уникальные слова: " + uniqueWords);
        System.out.println("Количество слов: " + wordsMap);

    }
}

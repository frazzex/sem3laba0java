import java.util.*;

public class Task3SetAndComparison {

    private static ArrayList<Human> generateHumanArrayList(int count) {
        Random rand = new Random();
        final ArrayList<String> NAMES = new ArrayList<>(Arrays.asList("Andrey", "Kanye", "Olga", "Artem", "Elena", "Kekich"));
        final ArrayList<String> SURNAMES = new ArrayList<>(Arrays.asList("West", "Tolokonnikov(a)", "Andreev", "Bobrova", "Kyrierovna"));

        ArrayList<Human> humans = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = NAMES.get(rand.nextInt(0, NAMES.size()));
            String surname = SURNAMES.get(rand.nextInt(0, SURNAMES.size()));
            int age = rand.nextInt(10, 91);
            humans.add(new Human(name, surname, age));
        }
        return humans;
    }

    public static void run() {

        ArrayList<Human> humans = generateHumanArrayList(5);
        System.out.println(humans);

        HashSet<Human> hashSetHumans = new HashSet<>(humans);
        System.out.println(hashSetHumans);

        LinkedHashSet<Human> linkedHashSetHumans = new LinkedHashSet<>(humans);
        System.out.println(linkedHashSetHumans);

        TreeSet<Human> treeSetHumans = new TreeSet<>(new HumanComparatorByLastName());
        treeSetHumans.addAll(humans);
        System.out.println(treeSetHumans);

        TreeSet<Human> treeSetHumans2 = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        treeSetHumans2.addAll(humans);
        System.out.println(treeSetHumans2);

        /*
        1. ArrayList - обычный динамический массив, наподобие vector в C++ или List в Python
        2. HashSet - структура с уникальными элементами, порядок элементов в которой не установлен
        3. LinkedHashSet - упорядоченная структура с уникальными элементами, построенная на основе двусвязанного списка. Хранит точный порядок добавления элементов
        4. TreeSet - Btree упорядоченная структура с уник. элементами, согласно компаратору сортирует элементы
        5. Тоже самое, только компаратор прописывается прямо при объявлении TreeSet
         */


    }
}

package app;

import model.Visitor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {

    protected static List<Visitor> visitors = Visitor.loadFromFile("books.json");

    public static void task1() {
        Stream<Visitor> visitorStream = visitors.stream();
        visitorStream.forEach(System.out::println);
        System.out.println("Общее кол-во записей: " + visitors.size());
    }

    public static void task2() {
        visitors.stream()
                .map(Visitor::getFavoriteBooks)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .distinct()
                .forEach(System.out::println);

    }

    public static void main(String[] args) {

        task2();

    }
}

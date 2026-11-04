package app;

import model.Visitor;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void task1() {
        List<Visitor> visitors = Visitor.loadFromFile("books.json");
        Stream<Visitor> visitorStream = visitors.stream();
        visitorStream.forEach(System.out::println);
        System.out.println("Общее кол-во записей: " + visitors.size());
    }

    public static void main(String[] args) {

        task1();

    }
}

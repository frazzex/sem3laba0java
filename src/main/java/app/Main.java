package app;

import model.Book;
import model.Visitor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    protected static List<Visitor> visitors = Visitor.loadFromFile("books.json");

    public static void task1() {
        Stream<Visitor> visitorStream = visitors.stream();
        visitorStream.forEach(System.out::println);
        System.out.println("Общее кол-во записей: " + visitors.size());
    }

    public static void task2() {
        List<Book> uniqueBooks = Book.getAllUniqueBooksFromVisitors(visitors);
        uniqueBooks.forEach(System.out::println);
        System.out.println("Количество уникальных книг: " + uniqueBooks.size());

    }

    public static void task3() {
        List<Book> uniqueBooks = Book.getAllUniqueBooksFromVisitors(visitors);
        uniqueBooks.stream()
                .sorted(Comparator.comparingInt(Book::getPublishingYear))
                .forEach(System.out::println);


    }

    public static void task4() {
        List<Book> allVisitorsBooks = Book.getAllBooksFromVisitors(visitors);
        Stream<Book> bookStream = allVisitorsBooks.stream();
        boolean isBookExist = bookStream.anyMatch(b -> b.getAuthor().equals("Jane Austen"));
        System.out.println("Есть ли у посетителей произведение автора Jane Austen: " + (isBookExist ? "Да" : "Нет"));
    }


    public static void task5() {
        int maxFavoriteBooksCount = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks() != null ? v.getFavoriteBooks().size() : 0)
                .max().orElse(0);

        System.out.println("Максимальное число книг у одного посетителя: " + maxFavoriteBooksCount);
    }

    public static void main(String[] args) {

        task5();

    }
}

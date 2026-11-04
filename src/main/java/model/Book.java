package model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    private String name;
    private String author;
    private int publishingYear;
    private String isbn;
    private String publisher;

    public static List<Book> getAllBooksFromVisitors(List<Visitor> visitors) {
        return visitors.stream()
                .map(Visitor::getFavoriteBooks)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .toList();
    }

    public static List<Book> getAllUniqueBooksFromVisitors(List<Visitor> visitors) {
        return Book.getAllBooksFromVisitors(visitors)
                .stream()
                .distinct()
                .toList();
    }
}

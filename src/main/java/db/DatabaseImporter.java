package db;

import models.BookDto;
import models.VisitorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseImporter {
    public static void importVisitorsFromJson(VisitorDto[] visitors, Connection conn) {
        String insertVisitorSql = """
                INSERT INTO visitors(name, surname, phone, subscribed) VALUES
                (?, ?, ?, ?) RETURNING id;
                """;

        String insertBookSql = """
                INSERT INTO books(name, author, publishing_year, isbn, publisher) VALUES
                (?, ?, ?, ?, ?) ON CONFLICT(isbn) DO UPDATE SET author = books.author
                RETURNING id;
                """;

        String insertLinkSql = """
                INSERT INTO visitor_books(visitor_id, book_id) VALUES
                (?, ?)
                ON CONFLICT DO NOTHING;
                """;

        for (VisitorDto visitor : visitors) {
            int visitorId;
            try (PreparedStatement visitorStmt = conn.prepareStatement(insertVisitorSql)) {
                visitorStmt.setString(1, visitor.getName());
                visitorStmt.setString(2, visitor.getSurname());
                visitorStmt.setString(3, visitor.getPhone());
                visitorStmt.setBoolean(4, visitor.isSubscribed());


                try (ResultSet rs = visitorStmt.executeQuery()) {
                    if (rs.next()) {
                        visitorId = rs.getInt("id");
                    } else {
                        throw new SQLException("Не удалось сохранить посетителя " + visitor.toString());
                    }
                }

                List<BookDto> books = visitor.getFavoriteBooks();
                if (books == null) continue;

                for (BookDto book : books) {
                    int bookId;

                    try (PreparedStatement bookStmt = conn.prepareStatement(insertBookSql)) {
                        bookStmt.setString(1, book.getName());
                        bookStmt.setString(2, book.getAuthor());
                        bookStmt.setInt(3, book.getPublishingYear());
                        bookStmt.setString(4, book.getIsbn());
                        bookStmt.setString(5, book.getPublisher());

                        try (ResultSet rs = bookStmt.executeQuery()) {
                            if (rs.next()) {
                                bookId = rs.getInt("id");
                            } else {
                                throw new SQLException("Не удалось получить ID книги: " + book.toString());
                            }
                        }

                        try (PreparedStatement linkStmt = conn.prepareStatement(insertLinkSql)) {
                            linkStmt.setInt(1, visitorId);
                            linkStmt.setInt(2, bookId);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }

                conn.commit();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

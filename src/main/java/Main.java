import db.DatabaseImporter;
import db.DatabaseManager;
import db.SqlScriptRunner;
import models.BookDto;
import models.JsonLoader;
import models.VisitorDto;

import java.sql.*;
import java.util.List;


public class Main {

    private static void task1(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery("SELECT * FROM study.music");
            while (result.next()) {
                System.out.println(result.getString("id") + " " + result.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    private static void task2(Connection conn) {
        String sql = """
                SELECT * FROM study.music
                WHERE name NOT ILIKE '%m%' AND
                name NOT ILIKE '%t%'
                """;
        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getString("id") + " " + result.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    private static void task3(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            String sql = """
                     INSERT INTO study.music(id, name) VALUES\s
                     ((SELECT max(id) FROM study.music) + 1, 'NTL - Летний')
                    \s""";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    private static void task4(Connection conn) {
        new SqlScriptRunner("books-create.sql").execute(conn);
        VisitorDto[] visitors = JsonLoader.loadVisitorsFromResource("books.json");
        DatabaseImporter.importVisitorsFromJson(visitors, conn);
    }

    private static void task5(Connection conn) {
        String sql = """
                SELECT * FROM books
                ORDER BY publishing_year;
                """;

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " " +
                                rs.getString("author") + " " +
                                rs.getInt("publishing_year") + " " +
                                rs.getString("isbn") + " " +
                                rs.getString("publisher")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void task6(Connection conn) {
        String sql = """
                SELECT * FROM books
                WHERE publishing_year < 2000
                ORDER BY publishing_year
                """;

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " " +
                                rs.getString("author") + " " +
                                rs.getInt("publishing_year") + " " +
                                rs.getString("isbn") + " " +
                                rs.getString("publisher")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void task7(Connection conn) {
        String insertBooksSql = """
                INSERT INTO books(name, author, publishing_year, isbn, publisher) VALUES
                ('Молчаливый боб', 'Толоконников А. А.', 2025, 'fg132g', 'HarperPerennial'),
                ('Разговорчивый боб', 'Толоконников А. А.', 2025, 'fg132ffg', 'HarperPerennial')
                ON CONFLICT(isbn) DO UPDATE SET name = EXCLUDED.name RETURNING id;
                """;

        String insertVisitorsSql = """
                INSERT INTO visitors(name, surname, phone, subscribed) VALUES
                ('Артем', 'Толоконников', '7123456789', true) ON CONFLICT DO NOTHING
                RETURNING id;
                """;

        String insertLinkSql = """
                INSERT INTO visitor_books(visitor_id, book_id) VALUES(
                ?, ?) ON CONFLICT DO NOTHING;
                """;

        try (Statement stmt = conn.createStatement()) {
            ResultSet rsVisitors = stmt.executeQuery(insertVisitorsSql);

            int visitorId = -1;
            if (rsVisitors.next()) {
                visitorId = rsVisitors.getInt("id");
            }

            ResultSet rsBooks = stmt.executeQuery(insertBooksSql);

            java.util.List<Integer> bookIds = new java.util.ArrayList<>();
            while (rsBooks.next()) {
                bookIds.add(rsBooks.getInt("id"));
            }

            if (visitorId != -1) {
                for (int bookId : bookIds) {
                    try (PreparedStatement preparedStmt = conn.prepareStatement(insertLinkSql)) {
                        preparedStmt.setInt(1, visitorId);
                        preparedStmt.setInt(2, bookId);

                        preparedStmt.executeUpdate();
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void task8(Connection conn) {
        String sql = """
                DROP TABLE visitor_books CASCADE;
                DROP TABLE books CASCADE;
                DROP TABLE visitors CASCADE;
                """;

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DatabaseManager.getConnection()) {
            new SqlScriptRunner("schema-study-create.sql").execute(conn);
            new SqlScriptRunner("music-create.sql").execute(conn);
            conn.setAutoCommit(false);
            task8(conn);

        }


    }
}

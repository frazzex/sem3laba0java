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

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DatabaseManager.getConnection()) {
            new SqlScriptRunner("schema-study-create.sql").execute(conn);
            new SqlScriptRunner("music-create.sql").execute(conn);
            conn.setAutoCommit(false);
            task4(conn);

        }


    }
}

import app.DatabaseManager;
import app.SqlScriptRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    private static void task1(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery("SELECT * FROM study.music");
            while (result.next()) {
                System.out.println(result.getString("id") + " " + result.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DatabaseManager.getConnection()) {
            new SqlScriptRunner("schema-study-create.sql").execute(conn);
            new SqlScriptRunner("music-create.sql").execute(conn);

            task1(conn);

        }


    }
}

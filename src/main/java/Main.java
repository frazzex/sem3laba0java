import app.DatabaseManager;
import app.SqlScriptRunner;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DatabaseManager.getConnection()) {
            new SqlScriptRunner("schema-study-create.sql").execute(conn);
            new SqlScriptRunner("music-create.sql").execute(conn);
        }


    }
}

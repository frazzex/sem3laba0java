package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    ConfigLoader.getByKey("db.host"),
                    ConfigLoader.getByKey("db.user"),
                    ConfigLoader.getByKey("db.password")
            );
        } catch (NullPointerException e) {
            throw new RuntimeException("Некорректные данные для подключения к БД!");
        } catch (SQLException e) {
            throw new RuntimeException("ошибка установки соединения с базой данных");
        }
    }
}

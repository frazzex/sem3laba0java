package app;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlScriptRunner {
    private final String sqlScript;

    public SqlScriptRunner(String resourceFileName) {
        this.sqlScript = this.loadFileAsString(resourceFileName);
    }

    private String loadFileAsString(String resourceFileName) {
        URL url = SqlScriptRunner.class.getClassLoader().getResource(resourceFileName);

        if (url == null) throw new RuntimeException("Не удалось открыть/прочитать файл " + resourceFileName);

        try {
            URI uri = url.toURI();
            Path path = Path.of(uri);
            return Files.readString(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void execute(Connection conn) {
        try (Statement stm = conn.createStatement()) {
            stm.execute(this.sqlScript);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package app;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class ConfigLoader {
    private final static Properties properties = new Properties();

    static {
        String dbPropertiesFileName = "database.properties";

        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(dbPropertiesFileName)) {
            if (input != null) {
                properties.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getByKey(String key) {
        return Objects.requireNonNull(properties.getProperty(key));
    }
}

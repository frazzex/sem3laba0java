package models;
import com.google.gson.Gson;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonLoader {
    public static VisitorDto[] loadVisitorsFromResource(String fileName) {
        try {
            URL url = JsonLoader.class.getClassLoader().getResource(fileName);
            if (url == null) {
                throw new RuntimeException("Файл не найден: " + fileName);
            }

            String jsonContent = Files.readString(Path.of(url.toURI()));
            Gson gson = new Gson();

            return gson.fromJson(jsonContent, VisitorDto[].class);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}

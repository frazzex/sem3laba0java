package model;

import app.Main;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Visitor {
    private String name;
    private String surname;
    private String phone;
    private boolean subscribed;
    private List<Book> favoriteBooks;

    public static List<Visitor> loadFromFile(String fileName) {
        Gson gson = new Gson();

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName)) {

            if (inputStream == null) {
                System.out.println("Файл не найден!");
                return List.of();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            Type visitorListType = new TypeToken<List<Visitor>>() {
            }.getType();
            return gson.fromJson(reader, visitorListType);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return List.of();
    }
}

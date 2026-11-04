package app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Visitor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Gson gson = new Gson();

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("books.json")) {

            if (inputStream == null) {
                System.out.println("Файл не найден!");
                return;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            Type visitorListType = new TypeToken<List<Visitor>>() {}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);

            for (Visitor v : visitors) System.out.println(v);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }




    }
}

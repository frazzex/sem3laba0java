package app;

import exceptions.InvalidRecordException;
import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;
import storage.ReadWritable;
import storage.TxtFileStorage;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = List.of(
                new Circle(10),
                new Rectangle(8, 14)
        );

        Path path = Path.of("figures.txt");
        ReadWritable storage = new TxtFileStorage();

        try {
            // Запись
            storage.write(path, figures);
            System.out.println("Фигуры успешно записаны в файл.");

            // Чтение
            List<Figure> loadedFigures = storage.read(path);
            System.out.println("\nПрочитанные фигуры:");
            for (Figure f : loadedFigures) {
                System.out.println(f);
            }

        } catch (InvalidRecordException e) {
            System.err.println(e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Причина: " + e.getCause().getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
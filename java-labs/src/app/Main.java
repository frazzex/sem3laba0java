package app;

import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;
import storage.BinaryFileStorage;
import storage.ReadWritable;
import storage.TxtFileStorage;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = List.of(
                new Circle(10),
                new Rectangle(8, 14),
                new Circle(3.14)
        );

        ReadWritable txtStorage = new TxtFileStorage();
        ReadWritable binStorage = new BinaryFileStorage();

        Path txtPath = Path.of("figures.txt");
        Path binPath = Path.of("figures.bin");

        testStorage(txtStorage, txtPath, figures);
        System.out.println("--------------------------------------------------");
        testStorage(binStorage, binPath, figures);
    }

    private static void testStorage(ReadWritable storage, Path path, List<Figure> figures) {
        try {
            System.out.println("Тестирование: " + storage.getClass().getSimpleName());

            storage.write(path, figures);
            System.out.println("Успешная запись в: " + path);

            List<Figure> loadedFigures = storage.read(path);
            System.out.println("Прочитано объектов: " + loadedFigures.size());
            for (Figure f : loadedFigures) {
                System.out.println(f);
            }

        } catch (Exception e) {
            System.err.println("Ошибка при работе с " + path + ": " + e.getMessage());
        }
    }
}
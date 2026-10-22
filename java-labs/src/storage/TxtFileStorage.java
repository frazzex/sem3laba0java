package storage;

import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TxtFileStorage implements ReadWritable {
    @Override
    public List<Figure> read(Path path) throws IOException {
        List<Figure> figures = new ArrayList<>();

        if (!Files.exists(path)) {
            return figures;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                String type = parts[0];

                if (type.equalsIgnoreCase("Circle") && parts.length == 2) {
                    double radius = Double.parseDouble(parts[1]);
                    figures.add(new Circle(radius));
                } else if (type.equalsIgnoreCase("Rectangle") && parts.length == 3) {
                    double sideA = Double.parseDouble(parts[1]);
                    double sideB = Double.parseDouble(parts[2]);
                    figures.add(new Rectangle(sideA, sideB));
                } else {
                    throw new IOException("Неизвестный тип фигуры или неверный формат строки: " + line);
                }
            }
        } catch (NumberFormatException e) {
            throw new IOException("Ошибка парсинга числовых параметров фигуры", e);
        }

        return figures;
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            if (figures != null) {
                for (Figure figure : figures) {
                    if (figure instanceof Circle circle) {
                        writer.write("Circle " + circle.getRadius());
                    } else if (figure instanceof Rectangle rect) {
                        writer.write("Rectangle " + rect.getSideA() + " " + rect.getSideB());
                    }
                    writer.newLine();
                }
            }
        }
    }
}

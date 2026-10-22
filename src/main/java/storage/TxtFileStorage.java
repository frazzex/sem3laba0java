package storage;

import exceptions.IncorrectFigureAttributeException;
import exceptions.InvalidRecordException;
import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TxtFileStorage implements ReadWritable {

    @Override
    public List<Figure> read(Path path) throws IOException, InvalidRecordException {
        List<Figure> figures = new ArrayList<>();

        if (!Files.exists(path)) {
            return figures;
        }

        // Используем java.nio и BufferedReader с кодировкой UTF-8
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(":");
                if (parts.length != 2) {
                    throw new InvalidRecordException(lineNumber, "Некорректный формат строки. Ожидалось 'Тип: Параметры'");
                }

                String type = parts[0].trim();
                String[] params = parts[1].trim().split("\\s+");

                try {
                    if (type.equalsIgnoreCase("Circle")) {
                        if (params.length != 1) {
                            throw new InvalidRecordException(lineNumber, "Для Circle требуется 1 параметр (радиус)");
                        }
                        double radius = Double.parseDouble(params[0]);
                        figures.add(new Circle(radius));

                    } else if (type.equalsIgnoreCase("Rectangle")) {
                        if (params.length != 2) {
                            throw new InvalidRecordException(lineNumber, "Для Rectangle требуется 2 параметра (сторона A и сторона B)");
                        }
                        double sideA = Double.parseDouble(params[0]);
                        double sideB = Double.parseDouble(params[1]);
                        figures.add(new Rectangle(sideA, sideB));

                    } else {
                        throw new InvalidRecordException(lineNumber, "Неизвестный тип фигуры: " + type);
                    }
                } catch (NumberFormatException e) {
                    // Сохраняем исключение преобразования числа как причину (cause)
                    throw new InvalidRecordException(lineNumber, "Ошибка преобразования числового параметра", e);
                } catch (IncorrectFigureAttributeException e) {
                    // Сохраняем исключение создания фигуры как причину (cause)
                    throw new InvalidRecordException(lineNumber, "Некорректный атрибут фигуры: " + e.getMessage(), e);
                }
            }
        }

        return figures;
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            if (figures != null) {
                for (Figure figure : figures) {
                    if (figure instanceof Circle circle) {
                        writer.write("Circle: " + circle.getRadius());
                    } else if (figure instanceof Rectangle rect) {
                        writer.write("Rectangle: " + rect.getSideA() + " " + rect.getSideB());
                    }
                    writer.newLine();
                }
            }
        }
    }
}
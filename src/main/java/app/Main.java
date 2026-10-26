package app;

import exceptions.IncorrectFigureAttributeException;
import exceptions.InvalidRecordException;
import geometry2d.Figure;
import geometry3d.Cylinder;
import storage.BinaryFileStorage;
import storage.ReadWritable;
import storage.TxtFileStorage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPathStr;
        String outputPathStr;

        if (args.length >= 2) {
            inputPathStr = args[0];
            outputPathStr = args[1];
        } else {
            System.out.print("Введите путь к текстовому входному файлу: ");
            inputPathStr = scanner.nextLine().trim();

            System.out.print("Введите путь к бинарному выходному файлу: ");
            outputPathStr = scanner.nextLine().trim();
        }

        Path inputPath = Path.of(inputPathStr);
        Path outputPath = Path.of(outputPathStr);

        ReadWritable txtStorage = new TxtFileStorage();
        ReadWritable binStorage = new BinaryFileStorage();

        List<Figure> figures = null;

        try {
            figures = txtStorage.read(inputPath);
            System.out.println("\n--- Файл успешно прочитан ---");
        } catch (InvalidRecordException e) {
            System.err.println("Ошибка формата файла: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Причина: " + e.getCause().getMessage());
            }
            return;
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода при чтении файла: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка при чтении: " + e.getMessage());
            return;
        }

        System.out.println("\nПрочитанный список фигур:");
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            System.out.printf("[%d] Тип: %s | Площадь: %.2f | Периметр: %.2f%n",
                    i + 1,
                    figure.getClass().getSimpleName(),
                    figure.area(),
                    figure.perimeter()
            );
            System.out.println("    Параметры (toString):\n" + figure);
        }

        if (figures.isEmpty()) {
            System.out.println("\nСписок фигур пуст. Создание цилиндра пропущено.");
        } else {
            Random random = new Random();
            Figure randomFoundation = figures.get(random.nextInt(figures.size()));

            System.out.println("\n--- Создание цилиндра ---");
            System.out.println("Выбранное случайное основание: " + randomFoundation.getClass().getSimpleName());

            double height = 0;
            while (height <= 0) {
                System.out.print("Введите высоту цилиндра (положительное число): ");
                if (scanner.hasNextDouble()) {
                    height = scanner.nextDouble();
                    if (height <= 0) {
                        System.out.println("Высота должна быть больше 0!");
                    }
                } else {
                    System.out.println("Ошибка ввода! Введите число.");
                    scanner.next();
                }
            }

            try {
                Cylinder cylinder = new Cylinder(randomFoundation, height);
                System.out.println("\nУспешно создан цилиндр:");
                System.out.println("Основание: " + cylinder.getFoundation().getClass().getSimpleName());
                System.out.println("Высота: " + cylinder.getHeight());
                System.out.printf("Объём цилиндра: %.2f%n", cylinder.volume());
                System.out.println("Полное описание цилиндра:\n" + cylinder);
            } catch (IncorrectFigureAttributeException e) {
                System.err.println("Ошибка атрибута при создании цилиндра: " + e.getMessage());
            }
        }

        try {
            binStorage.write(outputPath, figures);
            System.out.println("\nУспех: Данные успешно сохранены в бинарный файл -> " + outputPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении бинарного файла: " + e.getMessage());
        }
    }
}
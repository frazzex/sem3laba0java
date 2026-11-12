package app;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.stream.Stream;

public class DirectoryManager {

    public static void run() {
        String surname = "Tolokonnikov";
        String name = "Artemii";

        try {
            System.out.println("Создание корневой директории");
            Path rootDir = createRootDir(surname);

            System.out.println("Создание файла в корне");
            Path fileInRoot = createMainFile(rootDir, name);

            System.out.println("Создание вложенных директорий и копирование файла");
            Path targetDir = createNestedDirsAndCopyFile(rootDir, fileInRoot, name);

            System.out.println("Создание file1 и file2");
            createAdditionalFiles(rootDir);

            System.out.println("Рекурсивный обход директории " + surname);
            walkAndPrintDirectory(rootDir);

            System.out.println("Удаление директории dir1 со всем содержимым");
            deleteDirRecursively(rootDir.resolve("dir1"));


        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Path createRootDir(String surname) throws IOException {
        Path path = Paths.get(surname);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
            System.out.println("Создана директория: " + path.toAbsolutePath());
        } else {
            System.out.println("Директория уже существует: " + path.toAbsolutePath());
        }
        return path;
    }

    public static Path createMainFile(Path rootDir, String name) throws IOException {
        Path filePath = rootDir.resolve(name);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
            System.out.println("Создан файл: " + filePath);
        } else {
            System.out.println("Файл уже существует: " + filePath);
        }
        return filePath;
    }

    public static Path createNestedDirsAndCopyFile(Path rootDir, Path sourceFile, String name) throws IOException {
        Path nestedPath = rootDir.resolve("dir1/dir2/dir3");
        Files.createDirectories(nestedPath);
        System.out.println("Созданы вложенные директории: " + nestedPath);

        Path destinationFile = nestedPath.resolve(name);
        Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Файл скопирован в: " + destinationFile);

        return nestedPath;
    }

    public static void createAdditionalFiles(Path rootDir) throws IOException {
        Path file1 = rootDir.resolve("dir1/file1");
        if (!Files.exists(file1)) {
            Files.createFile(file1);
            System.out.println("Создан file1: " + file1);
        }

        Path file2 = rootDir.resolve("dir1/dir2/file2");
        if (!Files.exists(file2)) {
            Files.createFile(file2);
            System.out.println("Создан file2: " + file2);
        }
    }

    public static void walkAndPrintDirectory(Path rootDir) throws IOException {
        try (Stream<Path> stream = Files.walk(rootDir)) {
            stream.forEach(path -> {
                if (Files.isDirectory(path)) {
                    System.out.println("D: " + path);
                } else if (Files.isRegularFile(path)) {
                    System.out.println("F: " + path);
                }
            });
        }
    }

    public static void deleteDirRecursively(Path dirToDelete) throws IOException {
        if (Files.exists(dirToDelete)) {
            try (Stream<Path> stream = Files.walk(dirToDelete)) {
                stream.sorted(Comparator.reverseOrder())
                        .forEach(path -> {
                            try {
                                Files.delete(path);
                                System.out.println("Удалено: " + path);
                            } catch (IOException e) {
                                System.err.println("Не удалось удалить: " + path);
                            }
                        });
            }
        } else {
            System.out.println("Директория для удаления не найдена: " + dirToDelete);
        }
    }
}
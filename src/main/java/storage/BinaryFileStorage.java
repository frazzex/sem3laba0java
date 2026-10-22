package storage;

import geometry2d.Figure;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileStorage implements ReadWritable {

    @Override
    @SuppressWarnings("unchecked")
    public List<Figure> read(Path path) throws IOException, ClassNotFoundException {
        if (!Files.exists(path) || Files.size(path) == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Object obj = ois.readObject();

            if (!(obj instanceof List<?> list)) {
                throw new IOException("Файл содержит некорректный тип данных: ожидался List");
            }

            for (Object item : list) {
                if (item != null && !(item instanceof Figure)) {
                    throw new IOException("Список содержит объект, не являющийся Figure: " + item.getClass().getName());
                }
            }

            return (List<Figure>) list;

        } catch (StreamCorruptedException | ClassCastException e) {
            throw new IOException("Файл поврежден или имеет неверный формат бинарных данных", e);
        }
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(figures);
        }
    }
}
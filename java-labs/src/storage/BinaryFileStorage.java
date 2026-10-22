package storage;

import geometry2d.Figure;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            return (List<Figure>) ois.readObject();
        }
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(figures);
        }
    }
}

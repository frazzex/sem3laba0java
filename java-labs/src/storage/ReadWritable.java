package storage;
import exceptions.StorageException;
import geometry2d.Figure;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ReadWritable {

    public List<Figure> read(Path path) throws IOException, Exception;

    public void write(Path path, List<Figure> figures) throws IOException, Exception;

}

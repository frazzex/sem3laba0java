package storage;
import exceptions.InvalidRecordException;
import geometry2d.Figure;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ReadWritable {

    List<Figure> read(Path path) throws IOException, ClassNotFoundException, InvalidRecordException;
    public void write(Path path, List<Figure> figures) throws IOException, Exception;

}

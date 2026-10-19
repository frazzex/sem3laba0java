package geometry3d;

import geometry2d.Figure;
import exceptions.IncorrectFigureAttributeException;

public class Cylinder implements Figure {
    private final Figure foundation;
    private final double height;

    public Cylinder(Figure figure, double height) throws IncorrectFigureAttributeException {
        if (figure == null) throw new IncorrectFigureAttributeException("Основание цилиндра не должно быть null!");

        if (height <= 0 || !Double.isFinite(height))
            throw new IncorrectFigureAttributeException("Высота цилиндра должна быть конечным числом и больше нуля!");

        this.foundation = figure;
        this.height = height;
    }

    public Figure getFoundation() {
        return foundation;
    }

    public double getHeight() {
        return height;
    }
}

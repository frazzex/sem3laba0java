package geometry3d;

import geometry2d.Figure;
import exceptions.IncorrectFigureAttributeException;

public class Cylinder {
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

    public double volume() {
        return this.foundation.area() * this.height;
    }

    @Override
    public String toString() {
        return """
                {
                    Type: %s,
                    Parameters: {
                        Foundation: %s,
                        Height: %s,
                        Volume: %s
                    }
                }
                """.formatted(this.getClass().getSimpleName(), this.foundation.getClass().getSimpleName(), this.height, this.volume());
    }
}

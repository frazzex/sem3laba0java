package geometry2d;

import exceptions.IncorrectFigureAttributeException;

public class Circle implements Figure {
    private final double radius;

    public Circle(double radius) throws IncorrectFigureAttributeException {
        if (radius <= 0 || !Double.isFinite(radius))
            throw new IncorrectFigureAttributeException("Радиус круга должен быть конечным числом и больше нуля!");

        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

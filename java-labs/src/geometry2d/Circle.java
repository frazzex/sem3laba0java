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

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return """
                {
                    Type: %s,
                    Parameters: {
                        Radius: %s,
                        Area: %s,
                        Perimeter: %s
                    }
                }
                """.formatted(this.getClass().getSimpleName(), this.radius, this.area(), this.perimeter());
    }
}

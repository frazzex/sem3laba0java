package geometry2d;

import exceptions.IncorrectFigureAttributeException;

public class Rectangle implements Figure {
    private static final long serialVersionUID = 1L;

    private final double sideA;
    private final double sideB;

    public Rectangle(double sideA, double sideB) {
        if (
                sideA <= 0 || !Double.isFinite(sideA) ||
                        sideB <= 0 || !Double.isFinite(sideB)
        )
            throw new IncorrectFigureAttributeException("Стороны прямоугольника должны быть конечными числами и больше 0!");

        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    @Override
    public double area() {
        return this.sideA * this.sideB;
    }

    @Override
    public double perimeter() {
        return 2 * (this.sideA + this.sideB);
    }

    @Override
    public String toString() {
        return """
                {
                    Type: %s,
                    Parameters: {
                        SideA: %s,
                        SideB: %s,
                        Area: %s,
                        Perimeter: %s
                    }
                }
                """.formatted(this.getClass().getSimpleName(), this.sideA, this.sideB, this.area(), this.perimeter());
    }
}
package geometry2d;

import exceptions.IncorrectFigureAttributeException;

public class Rectangle implements Figure {
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
}

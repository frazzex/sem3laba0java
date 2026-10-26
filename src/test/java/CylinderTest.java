import exceptions.IncorrectFigureAttributeException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CylinderTest {

    private static final double EPSILON = 0.01;
    private static final Rectangle rectangle = new Rectangle(5.0, 4.0);

    @ParameterizedTest
    @CsvSource(value = {"5.0", "2.0", "10.0"})
    @DisplayName("Создание прямоугольника с допустимыми сторонами должно быть успешно")
    void shouldCreateRectangleSuccessfully(double height) {
        Cylinder cylinder = new Cylinder(rectangle, height);
        assertNotNull(cylinder);
        assertEquals(Rectangle.class, cylinder.getFoundation().getClass());
        assertEquals(height, cylinder.getHeight());
    }

    @Test
    void raisingExceptionWhenCylinderHeightIsZero() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Cylinder(rectangle, 0.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenCylinderHeightIsNaN() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Cylinder(rectangle, Double.NaN));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenCylinderHeightIsNegativeInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Cylinder(rectangle, Double.NEGATIVE_INFINITY));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenCylinderHeightIsPositiveInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Cylinder(rectangle, Double.POSITIVE_INFINITY));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenCylinderFoundationIsNull() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Cylinder(null, 5.0));
    }

    @ParameterizedTest
    @CsvSource(value = {"7.6, 2.0,362.92", "3.8, 10.12, 459.09"})
    void shouldReturnCylinderWithCircularBase(double radius, double height, double expected) {
        Circle circle = new Circle(radius);
        Cylinder cylinder = new Cylinder(circle, height);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4.3, 2.8, 7.0, 84.28",
            "6.4, 1.7, 2.0, 21.76",
    })
    void shouldReturnCylinderWithCRectangleBase(double sideA, double sideB, double height, double expected) {
        Rectangle rectangle = new Rectangle(sideA, sideB);
        Cylinder cylinder = new Cylinder(rectangle, height);
        assertEquals(expected, cylinder.volume(), EPSILON);
    }

    @ParameterizedTest
    @CsvSource(value = {"5.4, 10.5", "18.3, 15.4", "2.4, 88.98", "3.8, 228.6"})
    void shouldReturnCorrectRadius(double radius, double height) {
        Circle circle = new Circle(radius);
        Cylinder cylinder = new Cylinder(circle, height);
        assertEquals(circle.getClass(), cylinder.getFoundation().getClass());
        assertEquals(height, cylinder.getHeight());
    }

    @ParameterizedTest
    @CsvSource(value = {"5.4, 2.8", "13.6, 7.1", "8.8, 14.12"})
    void shouldIncludeTypeAndParametersInToString(double radius, double height) {
        Circle circle = new Circle(radius);
        Cylinder cylinder = new Cylinder(circle, height);
        String cylinderDescription = cylinder.toString();
        assertAll("Проверка описания объекта на наличие информации о типе и его параметрах",
                () -> assertTrue(cylinderDescription.contains("Cylinder")),
                () -> assertTrue(cylinderDescription.contains(cylinder.getFoundation().getClass().getSimpleName())),
                () -> assertTrue(cylinderDescription.contains(Double.toString(height))),
                () -> assertTrue(cylinderDescription.contains(Double.toString(cylinder.volume())))

        );
    }

}

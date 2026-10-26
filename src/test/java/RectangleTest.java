import geometry2d.Rectangle;
import exceptions.IncorrectFigureAttributeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RectangleTest {

    private static final double EPSILON = 1e-9;

    @ParameterizedTest
    @CsvSource(value = {"12.0, 3.0, 4.0", "4.0, 2.0, 2.0", "16.0, 2.0, 8.0"})
    void areaOfThreeByFoursRectanglesIsTwelve(double expected, double sideA, double sideB) {
        assertEquals(expected, new Rectangle(sideA, sideB).area(), EPSILON);

    }

    @ParameterizedTest
    @CsvSource(value = {"14.0, 3.0, 4.0", "8.0, 2.0, 2.0", "26.0, 7.0, 6.0"})
    void perimeterOfThreeByFourRectangleIsFourteen(double expected, double sideA, double sideB) {
        assertEquals(expected, new Rectangle(sideA, sideB).perimeter(), EPSILON);
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideAIsZero() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(0.0, 5.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideAIsNegative() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(-5.0, 5.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideAIsNaN() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(Double.NaN, 5.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideAIsNegativeInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(Double.NEGATIVE_INFINITY, 5.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideAIsPositiveInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(Double.POSITIVE_INFINITY, 5.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideBIsZero() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(5.0, 0.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideBIsNegative() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(5.0, -5.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideBIsNaN() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(5.0, Double.NaN));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideBIsNegativeInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(5.0, Double.NEGATIVE_INFINITY));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSideBIsPositiveInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(5.0, Double.POSITIVE_INFINITY));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSidesIsZero() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(0.0, 0.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSidesIsNegative() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(-5.0, -5.0));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSidesIsNaN() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(Double.NaN, Double.NaN));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSidesIsNegativeInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY));
    }

    @Test
    void shouldThrowIncorrectFigureAttributeExceptionWhenRectangleSidesIsPositiveInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Rectangle(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
    }


    @ParameterizedTest
    @CsvSource(value = {"5.0, 4.0", "1.0, 6.0", "10.0, 8.0"})
    @DisplayName("Создание прямоугольника с допустимыми сторонами должно быть успешно")
    void shouldCreateRectangleSuccessfully(double sideA, double sideB) {
        Rectangle rectangle = new Rectangle(sideA, sideB);
        assertNotNull(rectangle);
        assertEquals(sideA, rectangle.getSideA());
        assertEquals(sideB, rectangle.getSideB());
    }

    @ParameterizedTest
    @CsvSource(value = {"10.0, 3.45", "15.89, 24.879", "11.2, 10.0"})
    void shouldReturnCorrectSideA(double sideA, double sideB) {
        Rectangle rectangle = new Rectangle(sideA, sideB);
        assertEquals(sideA, rectangle.getSideA());
    }

    @ParameterizedTest
    @CsvSource(value = {"10.0, 3.45", "15.89, 24.879", "11.2, 10.0"})
    void shouldReturnCorrectSideB(double sideA, double sideB) {
        Rectangle rectangle = new Rectangle(sideA, sideB);
        assertEquals(sideB, rectangle.getSideB());
    }


}

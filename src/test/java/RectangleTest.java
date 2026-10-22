import geometry2d.Rectangle;
import exceptions.IncorrectFigureAttributeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RectangleTest {

    private static final double EPSILON = 1e-9;

    @Test
    void areaOfThreeByFoursRectanglesIsTwelve() {
        assertEquals(12.0, new Rectangle(3.0, 4.0).area(), EPSILON);
        assertEquals(4.0, new Rectangle(2.0, 2.0).area(), EPSILON);
        assertEquals(16.0, new Rectangle(2.0, 8.0).area(), EPSILON);

    }

    @Test
    void perimeterOfThreeByFourRectangleIsFourteen() {
        assertEquals(2 * (3.0 + 4.0), new Rectangle(3.0, 4.0).perimeter(), EPSILON);
        assertEquals(2 * (2.0 + 2.0), new Rectangle(2.0, 2.0).perimeter(), EPSILON);
        assertEquals(2 * (7.0 + 6.0), new Rectangle(7.0, 6.0).perimeter(), EPSILON);
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


    @Test
    @DisplayName("Создание прямоугольника с допустимыми сторонами должно быть успешно")
    void shouldCreateRectangleSuccessfully() {
        Rectangle rectangle1 = new Rectangle(5.0, 4.0);
        Rectangle rectangle2 = new Rectangle(1.0, 6.0);
        Rectangle rectangle3 = new Rectangle(10.0, 8.0);
        assertAll("Проверка объектов на null",
                () -> assertNotNull(rectangle1),
                () -> assertNotNull(rectangle2),
                () -> assertNotNull(rectangle3)
        );

        assertAll("Проверка атрибутов объектов",
                () -> assertEquals(5.0, rectangle1.getSideA()),
                () -> assertEquals(4.0, rectangle1.getSideB()),

                () -> assertEquals(1.0, rectangle2.getSideA()),
                () -> assertEquals(6.0, rectangle2.getSideB()),

                () -> assertEquals(10.0, rectangle3.getSideA()),
                () -> assertEquals(8.0, rectangle3.getSideB())
        );
    }

}

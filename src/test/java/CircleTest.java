import exceptions.IncorrectFigureAttributeException;
import geometry2d.Circle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CircleTest {

    private static final double EPSILON = 0.01;

    @Test
    @DisplayName("Вычисление площади круга должно быть корректным для различных допустимых радиусов")
    void testCircleAreaForVariousRadius() {
        assertEquals(1, new Circle(0.564).area(), EPSILON);
        assertEquals(28.27, new Circle(3).area(), EPSILON);
    }

    @Test
    @DisplayName("Проверка на вызов исключения `IncorrectFigureAttributeException` при создании круга с радиусом `0.0`")
    void shouldThrowIncorrectFigureAttributeExceptionWhenCircleRadiusIsZero() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Circle(0.0));

    }

    @Test
    @DisplayName("Проверка на вызов исключения `IncorrectFigureAttributeException` при создании круга с радиусом `0.0`")
    void shouldThrowIncorrectFigureAttributeExceptionWhenCircleRadiusIsNegative() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Circle(-5.0));

    }

    @Test
    @DisplayName("Проверка на вызов исключения `IncorrectFigureAttributeException` при создании круга с радиусом `NaN`")
    void shouldThrowIncorrectFigureAttributeExceptionWhenCircleRadiusIsNaN() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Circle(Double.NaN));

    }

    @Test
    @DisplayName("Проверка на вызов исключения `IncorrectFigureAttributeException` при создании круга с радиусом `Negative Infinity`")
    void shouldThrowIncorrectFigureAttributeExceptionWhenCircleRadiusIsNegativeInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Circle(Double.NEGATIVE_INFINITY));

    }

    @Test
    @DisplayName("Проверка на вызов исключения `IncorrectFigureAttributeException` при создании круга с радиусом `Positive Infinity`")
    void shouldThrowIncorrectFigureAttributeExceptionWhenCircleRadiusIsPositiveInfinity() {
        assertThrows(IncorrectFigureAttributeException.class, () -> new Circle(Double.POSITIVE_INFINITY));

    }

    @Test
    @DisplayName("Вычисление периметра круга должно быть корректным для различных допустимых радиусов")
    void testCirclePerimeterForVariousRadius() {
        Circle circle = new Circle(0.159);
        double perimeter = circle.perimeter();
        assertEquals(1.0, perimeter, EPSILON);
    }

    @Test
    @DisplayName("Создание круга с допустимым радиусом должно быть успешно")
    void shouldCreateCircleSuccessfully() {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(1.0);
        Circle circle3 = new Circle(10.0);
        assertAll("Проверка объектов на null",
                () -> assertNotNull(circle1),
                () -> assertNotNull(circle2),
                () -> assertNotNull(circle3)
        );

        assertAll("Проверка атрибутов объектов",
                () -> assertEquals(5.0, circle1.getRadius()),

                () -> assertEquals(1.0, circle2.getRadius()),

                () -> assertEquals(10.0, circle3.getRadius())
        );
    }
}

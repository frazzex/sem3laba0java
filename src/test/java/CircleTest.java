import exceptions.IncorrectFigureAttributeException;
import geometry2d.Circle;
import geometry3d.Cylinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircleTest {

    private static final double EPSILON = 0.01;

    @ParameterizedTest
    @CsvSource(value = {"1, 0.564", "28.27, 3"})
    @DisplayName("Вычисление площади круга должно быть корректным для различных допустимых радиусов")
    void testCircleAreaForVariousRadius(double expected, double radius) {
        assertEquals(expected, new Circle(radius).area(), EPSILON);
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

    @ParameterizedTest
    @CsvSource(value = {"5.0", "1.0", "10.0"})
    @DisplayName("Создание круга с допустимым радиусом должно быть успешно")
    void shouldCreateCircleSuccessfully(double radius) {
        Circle circle = new Circle(radius);
        assertNotNull(circle);
        assertEquals(radius, circle.getRadius());

    }

    @ParameterizedTest
    @CsvSource(value = {"10.5", "15.4", "88.98", "228.6"})
    void shouldReturnCorrectRadius(double radius) {
        Circle circle = new Circle(radius);
        assertEquals(radius, circle.getRadius());
    }

    @ParameterizedTest
    @CsvSource(value = {"5.4", "13.6", "14.12"})
    void shouldIncludeTypeAndParametersInToString(double radius) {
        Circle circle = new Circle(radius);
        String circleDescription = circle.toString();
        assertAll("Проверка описания объекта на наличие информации о типе и его параметрах",
                () -> assertTrue(circleDescription.contains("Circle")),
                () -> assertTrue(circleDescription.contains(Double.toString(circle.getRadius()))),
                () -> assertTrue(circleDescription.contains(Double.toString(circle.area()))),
                () -> assertTrue(circleDescription.contains(Double.toString(circle.perimeter())))

        );
    }
}

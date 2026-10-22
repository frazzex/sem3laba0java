import exceptions.IncorrectFigureAttributeException;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CylinderTest {

    private static final Rectangle rectangle = new Rectangle(5.0, 4.0);


    @Test
    @DisplayName("Создание прямоугольника с допустимыми сторонами должно быть успешно")
    void shouldCreateRectangleSuccessfully() {
        Cylinder cylinder1 = new Cylinder(rectangle, 5.0);
        Cylinder cylinder2 = new Cylinder(rectangle, 2.0);
        Cylinder cylinder3 = new Cylinder(rectangle, 10.0);
        assertAll("Проверка объектов на null",
                () -> assertNotNull(cylinder1),
                () -> assertNotNull(cylinder2),
                () -> assertNotNull(cylinder3)
        );

        assertAll("Проверка атрибутов объектов",
                () -> assertEquals(Rectangle.class, cylinder1.getFoundation().getClass()),
                () -> assertEquals(5.0, cylinder1.getHeight()),

                () -> assertEquals(Rectangle.class, cylinder2.getFoundation().getClass()),
                () -> assertEquals(2.0, cylinder2.getHeight()),

                () -> assertEquals(Rectangle.class, cylinder3.getFoundation().getClass()),
                () -> assertEquals(10.0, cylinder3.getHeight())
        );
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

}

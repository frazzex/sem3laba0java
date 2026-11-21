package ocp;

/**
 * Подсказка:
 * Каждый раз, когда появляется новый тип пользователя (например, student или employee),
 * придётся лезть в код метода и добавлять новое условие if.
 * Вспомните задание из предыдущих лабораторных с фигурами.
 */
public class DiscountCalculator {
    public double calculateDiscount(DiscountStrategy strategy, double price) {
        if (strategy == null || price <= 0) return 0.0;
        return strategy.calculate(price);
    }
}

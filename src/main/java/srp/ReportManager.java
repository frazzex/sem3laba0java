package srp;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Подсказка:
 * если нужно изменить способ хранения, формат отчёта, или формулу вычисления — придётся менять один и тот же класс.
 */

public class ReportManager {

    private final List<Integer> data;
    private final ReportCalculator calculator;
    private final FileReportSaver saver;

    public ReportManager(List<Integer> data, ReportCalculator calculator, FileReportSaver saver) {
        this.data = data;
        this.calculator = calculator;
        this.saver = saver;
    }
    public void generateReport() {
        System.out.println("=== Report ===");
        int sum = calculator.calculateSum(data);
        double avg = calculator.calculateAverage(data);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
        System.out.println("Generated at: " + LocalDateTime.now());

        saver.saveToFile(sum, avg);
    }
}

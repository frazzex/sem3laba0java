import java.util.Scanner;

public class Task8ConsoleMenu {
    public static void run() {

        do {
            System.out.println("""
                    Программа демонстрирует выполнение следующих задач:
                    1. Целочисленные ловушки
                    2. Вещественная арифметика
                    3. Побитовые операции
                    4. Обработка текста
                    5. Одномерные массивы
                    6. Многомерные массивы
                    7. Методы и передача аргументов
                    8. Выйти
                    
                    Для запуска демонстрации задания введите номер (1-8):
                    """);
            Scanner scanner = new Scanner(System.in);

            int number;

            do {
                if (!scanner.hasNextInt()) {
                    System.out.println("Ошибка! Введите корректный номер задачи!");
                    scanner.next();
                    continue;
                }

                number = scanner.nextInt();
                if (number < 1 || number > 8) {
                    System.out.println("Число должно быть только от 1 до 8! Попробуйте еще раз");
                    scanner.next();
                    continue;
                }

                break;

            } while(true);

            switch(number) {
                case 1 -> Task1DataTypes.run();
                case 2 -> Task2RealArithmetic.run();
                case 3 -> Task3BitwiseOperations.run();
                case 4 -> Task4TextProcessing.run();
                case 5 -> Task5OneDimensionalArrays.run();
                case 6 -> Task6MultiDimensionalArrays.run();
                case 7 -> Task7MethodsAndArguments.run();
                case 8 -> { scanner.close(); return;}
                default -> System.out.println("Неизвестный выбор");
            }
            System.out.println('\n');

        }
        while(true);


    }
}

package isp;

/**
 * Возможно, этот класс выполняет слишком много задач, которые ему не свойственны.
 * Проведите рефакторинг в соответствии с принципом ISP.
 */
public class OldPrinter implements Printer {

    @Override
    public void print(String document) {
        System.out.println("Печатаю: " + document);
    }
}


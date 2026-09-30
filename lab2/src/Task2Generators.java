import java.util.ArrayList;

public class Task2Generators {
    public static void run() {
        ArrayList<Integer> primeNumbers = PrimesGenerator.generate(5, 1000);
        System.out.println(primeNumbers);
        PrimesGeneratorTest.print(primeNumbers, 4);

    }
}

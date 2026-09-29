import java.util.ArrayList;
import java.util.Random;

public class PrimesGenerator {

    private static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static ArrayList<Integer> generate(int n, int limit) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        Random random = new Random();
        while (n != 0) {
            int number = random.nextInt(limit + 1);

            if (!isPrime(number)) continue;

            primeNumbers.add(number);
            n--;
        }
        return primeNumbers;
    }
}

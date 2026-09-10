package edu.course.lab01;

public class FizzBuzz {

    public static void run() {
        String text = "fizzbuzz";
        for (int i = 1; i <= 501; ++i) {
            if (i % 5 == 0 && i % 7 == 0)
            {
                System.out.println("fizzbuzz");
                continue;
            }

            if (i % 5 == 0) {
                System.out.println("fizz");
                continue;
            }

            if (i % 7 == 0) {
                System.out.println("buzz");
                continue;
            }

            System.out.println(i);

        }

    }
}

import threads.EvenThread;
import threads.OddRunnable;

public class Main {
    public static void main(String[] args) {
        Thread evenThread = new EvenThread();
        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();


    }
}

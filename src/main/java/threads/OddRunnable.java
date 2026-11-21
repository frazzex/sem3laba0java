package threads;

public class OddRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("OddRunnable: " + (i * 2 - 1));
        }
    }

}

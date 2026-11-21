package threads;

public class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("EvenThread: " + (i * 2));
        }
    }
}

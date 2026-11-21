package warehouse;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ShoeWarehouse {
    public static List<BaseFootwearType> shoeTypes = List.of(BaseFootwearType.values());
    private final Queue<Order> orders = new LinkedList<>();
    private final int capacity;
    private final ExecutorService fulfillmentExecutor;

    public ShoeWarehouse(int capacity, int fulfillmentThreads) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        if (fulfillmentThreads <= 0) {
            throw new IllegalArgumentException("Fulfillment threads count must be positive");
        }
        this.capacity = capacity;
        this.fulfillmentExecutor = Executors.newFixedThreadPool(fulfillmentThreads);
    }

    public void receiveOrder(Order order) {
        synchronized (this) {
            while (orders.size() >= capacity) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            orders.offer(order);
            System.out.println("[" + Thread.currentThread().getName() + "] Принят заказ: " + order);
            this.notifyAll();
        }
    }

    public Order fulfillOrder() {
        synchronized (this) {
            while (orders.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }

            Order order = orders.poll();
            System.out.println("[" + Thread.currentThread().getName() + "] Обработан заказ: " + order);
            this.notifyAll();
            return order;
        }
    }

    public Future<Order> submitFulfillOrder() {
        return fulfillmentExecutor.submit(this::fulfillOrder);
    }

    public void shutdownFulfillmentExecutor() {
        fulfillmentExecutor.shutdown();
        try {
            if (!fulfillmentExecutor.awaitTermination(30, TimeUnit.SECONDS)) {
                fulfillmentExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            fulfillmentExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
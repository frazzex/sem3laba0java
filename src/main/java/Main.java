import warehouse.BaseFootwearType;
import warehouse.Order;
import warehouse.ShoeWarehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int capacity = 5;
        int totalOrders = 15;
        int ordersPerConsumer = 5;
        int consumerCount = totalOrders / ordersPerConsumer;

        ShoeWarehouse warehouse = new ShoeWarehouse(capacity, consumerCount);
        ExecutorService orderSenderExecutor = Executors.newFixedThreadPool(2);

        Random random = new Random();
        List<BaseFootwearType> types = ShoeWarehouse.shoeTypes;

        List<Future<?>> sendFutures = new ArrayList<>();
        for (long i = 1; i <= totalOrders; i++) {
            BaseFootwearType shoeType = types.get(random.nextInt(types.size()));
            int quantity = random.nextInt(10) + 1;
            Order order = new Order(i, shoeType, quantity);

            sendFutures.add(orderSenderExecutor.submit(() -> warehouse.receiveOrder(order)));
        }

        List<Future<Order>> fulfillFutures = new ArrayList<>();
        for (int i = 0; i < totalOrders; i++) {
            fulfillFutures.add(warehouse.submitFulfillOrder());
        }

        for (Future<?> future : sendFutures) {
            try {
                future.get();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        shutdownExecutor(orderSenderExecutor);

        for (Future<Order> future : fulfillFutures) {
            try {
                future.get();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        warehouse.shutdownFulfillmentExecutor();

        System.out.println("Все заказы сгенерированы и обработаны.");
    }

    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
import warehouse.BaseFootwearType;
import warehouse.Order;
import warehouse.ShoeWarehouse;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int capacity = 5;
        int totalOrders = 15;
        int ordersPerConsumer = 5;
        int consumerCount = totalOrders / ordersPerConsumer;

        ShoeWarehouse warehouse = new ShoeWarehouse(capacity);

        Runnable producerTask = () -> {
            Random random = new Random();
            List<BaseFootwearType> types = ShoeWarehouse.shoeTypes;
            for (int i = 1; i <= totalOrders; i++) {
                BaseFootwearType shoeType = types.get(random.nextInt(types.size()));
                int quantity = random.nextInt(10) + 1;
                Order order = new Order(i, shoeType, quantity);
                warehouse.receiveOrder(order);
            }
        };

        Runnable consumerTask = () -> {
            for (int i = 0; i < ordersPerConsumer; i++) {
                warehouse.fulfillOrder();
            }
        };

        Thread producerThread = new Thread(producerTask, "Producer");

        Thread[] consumers = new Thread[consumerCount];
        for (int i = 0; i < consumerCount; i++) {
            consumers[i] = new Thread(consumerTask, "Consumer-" + (i + 1));
        }

        producerThread.start();
        for (Thread consumer : consumers) {
            consumer.start();
        }

        producerThread.join();
        for (Thread consumer : consumers) {
            consumer.join();
        }

        System.out.println("Все заказы сгенерированы и обработаны.");
    }
}

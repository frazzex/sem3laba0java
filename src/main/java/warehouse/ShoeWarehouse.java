package warehouse;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShoeWarehouse {
    public static List<BaseFootwearType> shoeTypes = List.of(BaseFootwearType.values());
    private Queue<Order> orders = new LinkedList<>();
    private final int capacity;

    public ShoeWarehouse(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
    }


    public void receiveOrder(Order order){
        synchronized (this) {
            while(orders.size() >= capacity) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            orders.offer(order);
            System.out.println("Принят заказ: " + order);
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
            System.out.println("Обработан заказ: " + order);
            this.notifyAll();
            return order;
        }
    }


}

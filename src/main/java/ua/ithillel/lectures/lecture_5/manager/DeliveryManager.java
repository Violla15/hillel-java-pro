package ua.ithillel.lectures.lecture_5.manager;

import ua.ithillel.lectures.lecture_5.order.AbstractOrder;
import ua.ithillel.lectures.lecture_5.service.DeliveryService;

import java.util.ArrayList;
import java.util.List;

public class DeliveryManager {
    private List<AbstractOrder> orders;

    public DeliveryManager() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(AbstractOrder order) {
        this.orders.add(order);
    }

    public void sowOrders() {
        for (AbstractOrder order : orders) {
            System.out.println("Order " + order.getId() + ", " + order.getAddress() + ", " + order.getDate());
        }
    }

    public void deliverOrders() {
        for (AbstractOrder order : orders) {
            DeliveryService service = order.getDeliveryService();
            service.deliverOrder(order);
        }
    }
}

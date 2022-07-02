package ua.ithillel.lectures.lecture_5.service;

import ua.ithillel.lectures.lecture_5.order.AbstractOrder;
import ua.ithillel.lectures.lecture_5.order.OrderStatus;

public class GlovoDeliveryService implements DeliveryService,Printable {
    @Override
    public AbstractOrder deliverOrder(AbstractOrder order) {
        order.setStatus(OrderStatus.IN_PROGRESS);
        System.out.println("Glovo is delivering order with id "+ order.getId());

        try {
            Thread.sleep(3000);
            order.setStatus(OrderStatus.DELIVERED);
            System.out.println("Glovo successfully order with id "+ order.getId());
        } catch (InterruptedException e) {
            order.setStatus(OrderStatus.ABORTED);
            System.out.println("Glovo aborted order with id ");
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public void print() {

    }
}

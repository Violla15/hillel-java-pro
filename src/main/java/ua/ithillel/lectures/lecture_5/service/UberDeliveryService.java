package ua.ithillel.lectures.lecture_5.service;

import ua.ithillel.lectures.lecture_5.order.AbstractOrder;
import ua.ithillel.lectures.lecture_5.order.OrderStatus;

public class UberDeliveryService implements DeliveryService{

    @Override
    public AbstractOrder deliverOrder(AbstractOrder order) {
        order.setStatus(OrderStatus.IN_PROGRESS);
        System.out.println("Uber is delivering order with id "+ order.getId());

        try {
            Thread.sleep(1000);
            order.setStatus(OrderStatus.DELIVERED);
            System.out.println("Uber successfully order with id "+ order.getId());
        } catch (InterruptedException e) {
            order.setStatus(OrderStatus.ABORTED);
            System.out.println("Uber aborted order with id ");
            throw new RuntimeException(e);
        }

        return order;
    }
}

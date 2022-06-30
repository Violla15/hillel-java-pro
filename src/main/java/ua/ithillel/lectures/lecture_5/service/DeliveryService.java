package ua.ithillel.lectures.lecture_5.service;

import ua.ithillel.lectures.lecture_5.order.AbstractOrder;

public interface DeliveryService {
    AbstractOrder deliverOrder (AbstractOrder order);
}

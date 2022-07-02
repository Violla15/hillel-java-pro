package ua.ithillel.lectures.lecture_5.order;

import ua.ithillel.lectures.lecture_5.service.DeliveryService;

public abstract class AbstractOrder {

    private long id;
    private String date;
    private String address;

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    private OrderStatus status;

    public AbstractOrder(long id, String date, String address) {
        this.id = id;
        this.date = date;
        this.address = address;

    }

    public abstract DeliveryService getDeliveryService();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

  }

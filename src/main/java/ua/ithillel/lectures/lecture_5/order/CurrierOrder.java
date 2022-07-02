package ua.ithillel.lectures.lecture_5.order;

import ua.ithillel.lectures.lecture_5.service.DeliveryService;
import ua.ithillel.lectures.lecture_5.service.GlovoDeliveryService;

public class CurrierOrder extends AbstractOrder {
    private String currierName;

    public CurrierOrder(long id, String date, String address) {
        super(id, date, address);
    }

    @Override
    public DeliveryService getDeliveryService() {
        return new GlovoDeliveryService();
    }

    public String getCurrierName() {
        return currierName;
    }

    public void setCurrierName(String currierName) {
        this.currierName = currierName;
    }

}

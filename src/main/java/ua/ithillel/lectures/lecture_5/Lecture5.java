package ua.ithillel.lectures.lecture_5;

import ua.ithillel.lectures.lecture_5.manager.DeliveryManager;
import ua.ithillel.lectures.lecture_5.order.AbstractOrder;
import ua.ithillel.lectures.lecture_5.order.CurrierOrder;
import ua.ithillel.lectures.lecture_5.order.OrderStatus;
import ua.ithillel.lectures.lecture_5.order.TaxiOrder;
import ua.ithillel.lectures.lecture_5.service.DeliveryService;

public class Lecture5 {
    public static void main(String[] args) {
        DeliveryManager manager = new DeliveryManager();


        TaxiOrder taxiOrder = new TaxiOrder(1, "01.09.2022", "KYiv 1");
        taxiOrder.setTaxiNumber("DY 4567 DR");

        TaxiOrder taxiOrder2 = new TaxiOrder(2, "06.09.2022", "Lviv 12");
        taxiOrder.setTaxiNumber("DY 4545 DR");

        CurrierOrder currierOrder = new CurrierOrder(3, "3.09.2022", "Odessa 3");
        currierOrder.setCurrierName("Igor");

        CurrierOrder currierOrder2 = new CurrierOrder(4, "3.10.2022", "Odessa 7");
        currierOrder.setCurrierName("Ivan");

        manager.addOrder(taxiOrder);
        manager.addOrder(taxiOrder2);
        manager.addOrder(currierOrder);
        manager.addOrder(currierOrder2);

        manager.sowOrders();
        manager.deliverOrders();

        Lecture5.NonStaticInner staticInner = new Lecture5().new NonStaticInner();
        staticInner.method();

        AbstractOrder order = new AbstractOrder(1, "2", "3") {
            @Override
            public DeliveryService getDeliveryService() {
                return null;
            }

            @Override
            public String getDate() {
                return "1.2";
            }
        };
    }

    static class StaticInner {
        private int a = 5;

        private void method() {
            System.out.println("Method");
        }
    }

    class NonStaticInner {
        private void method() {
            System.out.println("Method");
        }
    }
}
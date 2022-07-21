package ua.ithillel.lectures.lecture_12.chain;

import com.sun.net.httpserver.Filter;
import ua.ithillel.lectures.lecture_12.chain.bill.UAN100Bill;
import ua.ithillel.lectures.lecture_12.chain.bill.UAN10Bill;
import ua.ithillel.lectures.lecture_12.chain.bill.UAN20Bill;
import ua.ithillel.lectures.lecture_12.chain.bill.UAN50Bill;

public class ATM {
    public Chain billsChain;

    public ATM() {
        this.billsChain = new UAN100Bill();
        Chain c2 = new UAN50Bill();
        Chain c3 = new UAN20Bill();
        Chain c4 = new UAN10Bill();

        billsChain.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);

    }
}

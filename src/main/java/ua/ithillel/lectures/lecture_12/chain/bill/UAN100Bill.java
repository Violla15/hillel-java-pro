package ua.ithillel.lectures.lecture_12.chain.bill;

import ua.ithillel.lectures.lecture_12.chain.Chain;
import ua.ithillel.lectures.lecture_12.chain.Currency;

public class UAN100Bill implements Chain {
    private Chain next;

    @Override
    public void setNextChain(Chain chain) {
        this.next = chain;
    }

    @Override
    public void give(Currency currency) {
        if (currency.getAmount() >= 100) {
            int num = currency.getAmount() / 100;
            int remainder = currency.getAmount() % 100;
            System.out.println("Giving " + num + " of 100 bill(s)");
            if (remainder != 0) {
                this.next.give(new Currency(remainder));
            }
        } else {
            this.next.give(currency);
        }
    }
}

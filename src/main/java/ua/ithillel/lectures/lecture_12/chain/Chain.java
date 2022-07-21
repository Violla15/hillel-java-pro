package ua.ithillel.lectures.lecture_12.chain;

public interface Chain {

    void  setNextChain(Chain chain);

    void give(Currency currency);
}

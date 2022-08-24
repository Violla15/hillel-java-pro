package ua.ithillel.lectures.lecture_19.account;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message) {
        super(message);
    }

}

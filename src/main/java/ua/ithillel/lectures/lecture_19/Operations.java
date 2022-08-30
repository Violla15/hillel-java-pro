package ua.ithillel.lectures.lecture_19;

import ua.ithillel.lectures.lecture_19.account.Account;
import ua.ithillel.lectures.lecture_19.account.InsufficientFundsException;

import java.util.concurrent.TimeUnit;

public class Operations {
    public static void main(String[] args) {
        Account a = new Account(1000);
        Account b = new Account(2000);

        Thread thread1 = new Thread("Thread 1") {
            @Override
            public void run() {
                try {
                    System.out.println("Running in " + getName());
                    transfer(a, b, 500);
                } catch (InsufficientFundsException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();

        try {
            System.out.println("Running in main thread");
            transfer(b, a, 200);
        } catch (InsufficientFundsException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void transfer(Account acc1, Account acc2, int amount) throws InsufficientFundsException, InterruptedException {
        if (acc1.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds , less than " + amount);
        }

        if (acc1.getLock().tryLock(5, TimeUnit.SECONDS)) {
            Thread.sleep(1000);
            if (acc2.getLock().tryLock(5, TimeUnit.SECONDS)) {
                acc1.withdraw(amount);
                acc2.deposit(amount);

                System.out.println("Transfer successful : ");
                System.out.println("Account 1 balance = " + acc1.getBalance());
                System.out.println("Account 2 balance = " + acc2.getBalance());
            }
            acc2.getLock().unlock();
        }
        acc1.getLock().unlock();
    }
}



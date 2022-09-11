package ua.ithillel.lectures.lecture_19;

public class Lecture19 {
    public static void main(String[] args) {
        Thread myThread = new Thread("Thread 1") {
            @Override
            public void run() {
                System.out.println("Running my thread... " + getName());
            }
        };

        Runnable runnable = () -> System.out.println("Running my thread 2 ...");

        Thread myThread2 = new Thread(runnable, "Thread 2");

        myThread.start();
        myThread2.start();

        System.out.println("Running main thread...");
    }
}


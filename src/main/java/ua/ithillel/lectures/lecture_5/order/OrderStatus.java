package ua.ithillel.lectures.lecture_5.order;

public enum OrderStatus {
    NEW(1),
    IN_PROGRESS(2),
    DELIVERED(3),
    ABORTED(4),
    CLOSED(5);
    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void printStatus() {
        System.out.println(" Status is " + value);
    }
}

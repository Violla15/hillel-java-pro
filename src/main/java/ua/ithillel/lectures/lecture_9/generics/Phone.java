package ua.ithillel.lectures.lecture_9.generics;

public class Phone extends Product{

    private String model;

    public Phone(String name, int price) {
        super(name, price);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

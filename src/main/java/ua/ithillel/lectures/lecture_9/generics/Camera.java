package ua.ithillel.lectures.lecture_9.generics;

public class Camera extends Product{

    private int pixels;

    public Camera(String name, int price) {
        super(name, price);
    }

    public int getPixels() {
        return pixels;
    }

    public void setPixels(int pixels) {
        this.pixels = pixels;
    }
}

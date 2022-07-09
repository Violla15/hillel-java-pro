package ua.ithillel.lectures.lecture_4.polymorphism;

public class AudioPlayer {

    public static final String FINAL_VERSION = "1.0";
    public void play(){
        System.out.println("Audio player is playing ...");
    }
    static {
        int a = 2;
        int b = a +2;
    }
    public static void go(){
        System.out.println("go");
    }
}

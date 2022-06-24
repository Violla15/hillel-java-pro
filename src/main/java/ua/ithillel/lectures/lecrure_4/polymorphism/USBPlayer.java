package ua.ithillel.lectures.lecrure_4.polymorphism;

public class USBPlayer extends AudioPlayer {

    public void play(){
        System.out.println("USB player is playing ...");
    }
    public void play(String song){
        System.out.println("Song is playing "+ song);
    }
    public void play(String song, int duration) {
        System.out.println("Song is playing " + song);
    }
    public void play(int song, int duration){
        System.out.println("Song is playing "+ song);
    }
}

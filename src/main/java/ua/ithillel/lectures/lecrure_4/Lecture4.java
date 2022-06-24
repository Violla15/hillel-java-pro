package ua.ithillel.lectures.lecrure_4;

import ua.ithillel.lectures.lecrure_4.encapsulation.Encapsulation;
import ua.ithillel.lectures.lecrure_4.immutable.ImmutableStudent;
import ua.ithillel.lectures.lecrure_4.polymorphism.AudioPlayer;
import ua.ithillel.lectures.lecrure_4.polymorphism.CDPlayer;
import ua.ithillel.lectures.lecrure_4.polymorphism.USBPlayer;

import java.util.ArrayList;
import java.util.List;

public class Lecture4 {
    public static void main(String[] args) {
        Encapsulation encapsulation = new Encapsulation();

        ImmutableStudent immutableStudent = new ImmutableStudent("Ivan", "Ivan@gmail.com", new String[]{"QA", "Java"});
        String email = immutableStudent.getEmail();
        email = "Ivanov@gmail.com";
        String[] groups = immutableStudent.getGroup();
        groups[0] = "A";

        System.out.println(immutableStudent);

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play();

        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.play();

        USBPlayer usbPlayer = new USBPlayer();
        usbPlayer.play();

        List<AudioPlayer> players = new ArrayList<>();
        players.add(audioPlayer);
        players.add(cdPlayer);
        players.add(usbPlayer);

        play(players);
    }

    private static void play(List<AudioPlayer> players) {
        for (AudioPlayer player : players) {
            player.play();
        }
    }
}

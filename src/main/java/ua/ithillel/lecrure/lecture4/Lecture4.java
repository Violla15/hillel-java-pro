package ua.ithillel.lecrure.lecture4;

import ua.ithillel.homeworks.homework4.encapsulatioln.Encapsulation;
import ua.ithillel.homeworks.homework4.immutable.ImmutableStudent;
import ua.ithillel.homeworks.homework4.polymorphism.AudioPlayer;
import ua.ithillel.homeworks.homework4.polymorphism.CDPlayer;
import ua.ithillel.homeworks.homework4.polymorphism.USBPlayer;

import java.util.ArrayList;
import java.util.List;

public class Lecture4 {
    public static void main(String[] args) {
        Encapsulation encapsulation = new Encapsulation();


        ImmutableStudent immutableStudent = new ImmutableStudent("Ivan", "Ivan@gmail.com", new String[]{"QA", "Java"});
        String email = immutableStudent.getEmail();
        email = "new@gmail.com";
        String[] group = immutableStudent.getGroup();
        group[0] = "A";

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
        encapsulation.myString2 = "Bbb";

    }

    private static void play(List<AudioPlayer> players) {
        for (AudioPlayer player : players) {
            player.play();
        }
    }
}

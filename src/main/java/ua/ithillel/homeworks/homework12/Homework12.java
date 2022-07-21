package ua.ithillel.homeworks.homework12;

import ua.ithillel.homeworks.homework12.builder.*;
import ua.ithillel.homeworks.homework12.facade.Group;

public class Homework12 {
    public static void main(String[] args) {

        heroBuilder();                   // task 1 - Builder hero


        Group group = new Group();       // task 2 - example of using facade-pattern
        group.startPHP();
        group.startPython();
        group.startJavaPro();
    }

    public static void heroBuilder() {
        Hero nick = new Hero.HeroBuilder("Nick", 10)
                .profession(Profession.DOCTOR)
                .armor(Armor.CIO)
                .weapon(Weapon.BOW)
                .hairColor(HairColor.BLUE)
                .build();

        System.out.println(nick);

        Hero den = new Hero.HeroBuilder("Den", 15)
                .profession(Profession.OFFICER)
                .armor(Armor.AVIATOR)
                .weapon(Weapon.BLADES)
                .hairColor(HairColor.BLACK)
                .build();

        System.out.println(den);

        Hero alice = new Hero.HeroBuilder("Alice", 8)
                .profession(Profession.NORSE)
                .weapon(Weapon.GUN)
                .hairColor(HairColor.PINK)
                .build();

        System.out.println(alice);

        Hero bob = new Hero.HeroBuilder("Bob", 13)
                .profession(Profession.SOLDIER)
                .armor(Armor.EOD)
                .weapon(Weapon.CROSSBOW)
                .hairColor(HairColor.GRIN)
                .build();

        System.out.println(bob);
    }
}


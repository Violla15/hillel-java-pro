package ua.ithillel.homeworks.homework13;

import ua.ithillel.homeworks.homework13.exception.XmlSerializableException;
import ua.ithillel.homeworks.homework13.person.Person;

import java.util.List;


public class Homework13 {
    public static void main(String[] args) throws XmlSerializableException {
        Person person1 = new Person("Ivan", "Ivanov", "Kiev");
        Person person2 = new Person("Oleg", "Petrenko", "Kiev");


        XmlSerializer xmlSerializer = new XmlSerializer();
        List <String> stringList = xmlSerializer.serialize(List.of(person1,person2));
        stringList.forEach(System.out::println);

    }
}


package ua.ithillel.homeworks.homework13;

import ua.ithillel.homeworks.homework13.exception.XmlSerializableException;
import ua.ithillel.homeworks.homework13.person.Person;

import java.util.ArrayList;
import java.util.List;


public class Homework13 {
    public static void main(String[] args) throws XmlSerializableException {
        Person person1 = new Person("Ivan", "Ivanov", "Kiev");
        Person person2 = new Person("Oleg", "Petrenko", "Kiev");

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

        XmlSerializer xmlSerializer = new XmlSerializer();
        xmlSerializer.serialize(people);


    }
}

package ua.ithillel.homeworks.homework17;

import ua.ithillel.homeworks.homework17.person.Person;


import java.util.List;

public class Homework17 {
    public static void main(String[] args) {

        getInfoAboutPerson();
    }

    private static void getInfoAboutPerson() {
        Person person1 = new Person("Ivan", "Ivanov", 25, "Ukraine");
        Person person2 = new Person("Nikolay", "Petrov", 32, "Ukraine");
        Person person3 = new Person("Stepan", "Vasiliev", 30, "Poland");

        List<Person> people = List.of(person1, person2, person3);

        for (Person person : people) {
            System.out.println("Person : " + person.getName() + " " + person.getSurname() + ", age - " + person.getAge());
        }
    }
}


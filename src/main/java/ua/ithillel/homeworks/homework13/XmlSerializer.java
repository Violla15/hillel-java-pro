package ua.ithillel.homeworks.homework13;

import ua.ithillel.homeworks.homework13.annotation.XmlElement;
import ua.ithillel.homeworks.homework13.annotation.XmlSerializable;
import ua.ithillel.homeworks.homework13.exception.XmlSerializableException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class XmlSerializer {
    List<String> people = new ArrayList<>();
    public List<String> serialize(List<Person> objects) throws XmlSerializableException {
        if (!objects.isEmpty()) {
            for (Person person : objects) {
                Class<?> personClass = Person.class;
                if (personClass.isAnnotationPresent(XmlSerializable.class)) {
                    String annotation = personClass.getAnnotation(XmlSerializable.class).key();
                    System.out.println("<" + annotation + ">");
                    Field[] fields = personClass.getDeclaredFields();
                    if (fields[0].isAnnotationPresent(XmlElement.class)) {
                        String key = fields[0].getAnnotation(XmlElement.class).key();
                        if (!key.equals("")) {
                            System.out.println("  <" + key + ">" + person.getName() + "<" + key + "/>");
                        } else {
                            System.out.println("  <" + fields[0].getName() + ">" + person.getAddress() + "<" + fields[0].getName() + "/>");
                        }
                    }
                    if (fields[1].isAnnotationPresent(XmlElement.class)) {
                        String key = fields[1].getAnnotation(XmlElement.class).key();
                        if (!key.equals("")) {
                            System.out.println("  <" + key + ">" + person.getSurName() + "<" + key + "/>");
                        } else {
                            System.out.println("  <" + fields[1].getName() + ">" + person.getAddress() + "<" + fields[1].getName() + "/>");
                        }
                    }
                    if (fields[2].isAnnotationPresent(XmlElement.class)) {
                        String key = fields[2].getAnnotation(XmlElement.class).key();
                        if (!key.equals("")) {
                            System.out.println("  <" + key + ">" + person.getAddress() + "<" + key + "/>");
                        } else {
                            System.out.println("  <" + fields[2].getName() + ">" + person.getAddress() + "<" + fields[2].getName() + "/>");
                        }
                    }
                    System.out.println("<" + annotation + "/>");
                }
            }
            return people;
        }
        throw new XmlSerializableException("The class with name <Class> is not annotated with @XmlSerializable");
    }
}



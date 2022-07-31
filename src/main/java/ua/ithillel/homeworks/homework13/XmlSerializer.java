package ua.ithillel.homeworks.homework13;

import ua.ithillel.homeworks.homework13.annotation.XmlElement;
import ua.ithillel.homeworks.homework13.annotation.XmlSerializable;
import ua.ithillel.homeworks.homework13.exception.XmlSerializableException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class XmlSerializer<T> {
    List<String> people = new ArrayList<>();

    public List<String> serialize(List<T> objects) throws XmlSerializableException {
        if (!objects.isEmpty()) {
            for (T t : objects) {
                Class<?> personClass = t.getClass();
                if (personClass.isAnnotationPresent(XmlSerializable.class)) {
                    people.add("<" + personClass.getAnnotation(XmlSerializable.class).key() + ">\n");
                    Field[] fields = personClass.getDeclaredFields();
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(XmlElement.class)) {
                            String key = field.getAnnotation(XmlElement.class).key();
                            field.setAccessible(true);
                            if (!key.equals("")) {
                                try {
                                    people.add("   <" + key + ">" + field.get(t) + "</" + key + ">\n");
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    people.add("   <" + field.getName() + ">" + field.get(t) + "</" + field.getName() + ">\n");
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                people.add("</" + personClass.getAnnotation(XmlSerializable.class).key() + ">\n");
            }
            System.out.println(people);
            return people;
        }
        throw new XmlSerializableException("The class with name <Class> is not annotated with @XmlSerializable");
    }
}


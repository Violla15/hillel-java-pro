package ua.ithillel.homeworks.homework13;

import ua.ithillel.homeworks.homework13.annotation.XmlElement;
import ua.ithillel.homeworks.homework13.annotation.XmlSerializable;
import ua.ithillel.homeworks.homework13.exception.XmlSerializableException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class XmlSerializer {

    public <T> List<String> serialize(List<T> objects) throws XmlSerializableException {
        List<String> stringList = new ArrayList<>();
        if (!objects.isEmpty()) {
            for (T t : objects) {
                Class<?> personClass = t.getClass();
                if (!personClass.isAnnotationPresent(XmlSerializable.class)) {
                    throw new XmlSerializableException("The class with name <Class> is not annotated with @XmlSerializable");
                }
                if (!personClass.getAnnotation(XmlSerializable.class).key().equals("")) {
                    stringList.add("<" + personClass.getAnnotation(XmlSerializable.class).key() + ">");
                } else {
                    stringList.add("<" + personClass.getAnnotation(XmlSerializable.class).getClass() + ">");
                }
                Field[] fields = personClass.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(XmlElement.class)) {
                        String key = field.getAnnotation(XmlElement.class).key();
                        field.setAccessible(true);
                        if (!key.equals("")) {
                            try {
                                stringList.add("   <" + key + ">" + field.get(t) + "</" + key + ">");
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                stringList.add("   <" + field.getName() + ">" + field.get(t) + "</" + field.getName() + ">");
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                stringList.add("</" + personClass.getAnnotation(XmlSerializable.class).key() + ">");
            }
        }
        return stringList;
    }
}


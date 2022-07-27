package ua.ithillel.lectures.lecture_13;

import ua.ithillel.lectures.lecture_13.annotation.Service;
import ua.ithillel.lectures.lecture_13.service.ServiceLoader;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(name = "name", lazyLoad = true)
public class Lecture13 {
    @SuppressWarnings(" rawtypes")
    public static void main(String[] args) {
        Lecture13 lecture13 = new Lecture13();
        lecture13.myMethod();
        List rawList = new ArrayList();
        getClassObject();

        ServiceLoader serviceLoader = new ServiceLoader();
        serviceLoader.loadService("ua.ithillel.lectures.lecture13.service.SimpleService");
        serviceLoader.loadService("ua.ithillel.lectures.lecture13.service.LazyService");
        serviceLoader.loadService("java.lang.String");

        for (Map.Entry<String, Object> entry : serviceLoader.getServiceMap().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        serviceLoader.init();
    }

    private static void getClassObject() {
        Lecture13 lecture13 = new Lecture13();
        Class<?> aClass = lecture13.getClass();
        Class<?> a1Class = Lecture13.class;

        try {
            Class<?> a2Class = Class.forName("ua.ithillel.lectures.lecture_13");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();

        Class<?> superClass = aClass.getSuperclass();
        System.out.println(name);
        System.out.println(simpleName);
        System.out.println(superClass);
    }

    /**
     * use {@link Lecture13#newMethod()}  instead
     */
    @Deprecated
    private void myMethod() {
        System.out.println("logic");
    }

    private void newMethod() {
        System.out.println("new method");
    }

    @Override
    public String toString() {
        return "Lecture13{}";
    }
}

package ua.ithillel.lectures.lecture_13.service;

import ua.ithillel.lectures.lecture_13.annotation.Init;
import ua.ithillel.lectures.lecture_13.annotation.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class ServiceLoader {
    private Map<String, Object> serviceMap;

    public ServiceLoader() {
        this.serviceMap = new HashMap<>();
    }

    public void loadService(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Service.class)) {
                Object serviceObj = clazz.getConstructor().newInstance();
                String serviceName = clazz.getAnnotation(Service.class).name();
                serviceMap.put(serviceName, serviceObj);
            } else {
                System.out.println("Annotation @Service is absent for class " + className);
            }
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() {
        if (!serviceMap.isEmpty()) {
            for (Object service : serviceMap.values()) {
                Class<?> serviceClass = service.getClass();

                Method[] declaredMethods = serviceClass.getDeclaredMethods();

                for (Method method : declaredMethods) {
                    if (method.isAnnotationPresent(Init.class)) {
                        try {
                            method.invoke(service);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public Map<String, Object> getServiceMap() {
        return serviceMap;
    }
}


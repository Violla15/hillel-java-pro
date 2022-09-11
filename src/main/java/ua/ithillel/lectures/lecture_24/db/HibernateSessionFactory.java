package ua.ithillel.lectures.lecture_24.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.ithillel.lectures.lecture_24.entity.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HibernateSessionFactory {

    private static final String PROPERTIES_PATH = "src/main/java/ua/ithillel/lectures/lecture_24/hibernate.properties";

    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() throws IOException {
        if (sessionFactory == null) {
            sessionFactory = createConfiguration().buildSessionFactory();
        }

        return sessionFactory;
    }

    private static Configuration createConfiguration() throws IOException {
        Configuration cfg = new Configuration();

        cfg.addAnnotatedClass(Car.class);
        cfg.addAnnotatedClass(Client.class);
        cfg.addAnnotatedClass(Manager.class);
        cfg.addAnnotatedClass(Order.class);
        cfg.addAnnotatedClass(Role.class);

        Properties properties = new Properties();

        // load from properties file
        properties.load(new FileReader(PROPERTIES_PATH));
        cfg.setProperties(properties);

        return cfg;
    }
}


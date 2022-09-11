package ua.ithillel.homeworks.homework24;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import ua.ithillel.lectures.lecture_24.db.HibernateSessionFactory;
import ua.ithillel.lectures.lecture_24.entity.Car;
import ua.ithillel.lectures.lecture_24.entity.Manager;
import ua.ithillel.lectures.lecture_24.entity.Order;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Homework24 {

    public static void main(String[] args) {
        try {
            System.out.println("Managers in the table where id less 5 : ");
            getManager();
            System.out.println("\nOrder with date before 01.28.2022  :");
            getOrder();
            System.out.println("\nCar with largest price : ");
            getCarId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getManager() throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Manager> crq = cb.createQuery(Manager.class);
            Root<Manager> root = crq.from(Manager.class);
            crq.select(root).where(cb.lt(root.get("id"), 5));
            List<Manager> list = session.createQuery(crq).getResultList();
            list.forEach(System.out::println);
        }
    }

    public static void getCarId() throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Integer> crq = cb.createQuery(Integer.class);
            Root<Car> root = crq.from(Car.class);
            crq.select(cb.max(root.get("price")));
            Object car = session.createQuery(crq).getSingleResult();
            int id = (int) car;
            CriteriaQuery<Car> crq2 = cb.createQuery(Car.class);
            Root<Car> root2 = crq2.from(Car.class);
            crq2.select(root2).where(cb.equal(root2.get("price"), id));
            System.out.println(session.createQuery(crq2).getSingleResult());
        }
    }

    public static void getOrder() throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Order> crq = cb.createQuery(Order.class);
            Root<Order> root = crq.from(Order.class);
            String stringDate = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(stringDate);
            Date date = simpleDateFormat.parse("2022-01-28");
            crq.select(root).where(cb.lessThan(root.get("date"), date));
            List<Order> list = session.createQuery(crq).getResultList();
            list.forEach(System.out::println);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

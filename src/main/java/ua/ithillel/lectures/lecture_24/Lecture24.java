package ua.ithillel.lectures.lecture_24;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.ithillel.lectures.lecture_24.dao.CarDAO;
import ua.ithillel.lectures.lecture_24.db.HibernateSessionFactory;
import ua.ithillel.lectures.lecture_24.entity.Car;
import ua.ithillel.lectures.lecture_24.entity.Manager;
import ua.ithillel.lectures.lecture_24.entity.Order;

import java.io.IOException;
import java.util.List;

public class Lecture24 {

    public static void main(String[] args) throws IOException {
        CarDAO carDAO = new CarDAO();
        Car car = carDAO.findById(1);

        System.out.println(car);
        List<Order> orders = car.getOrders();
        orders.forEach(System.out::println);

        List<Car> cars = carDAO.findAll();

        cars.forEach(System.out::println);

        Car newCar = new Car();
        newCar.setId(99);
        newCar.setManufacturer("Jeep");
        newCar.setModel("Compass");
        newCar.setPrice(200);
        newCar.setYear(2019);
        newCar.setAvailable(true);

        //  carDAO.save(newCar);

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            String hql = "SELECT m FROM Manager m WHERE m.id = 1";
            Query query = session.createQuery(hql, Manager.class);
            Manager manager = (Manager) query.getSingleResult();

            System.out.println("Manager with id 1 : ");
            System.out.println(manager);

            System.out.println("Manager orders : ");
            List<Order> managerOrders = manager.getOrders();
            managerOrders.forEach(System.out::println);
        }
    }
}


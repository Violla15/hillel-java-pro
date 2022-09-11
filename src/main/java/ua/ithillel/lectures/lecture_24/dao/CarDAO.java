package ua.ithillel.lectures.lecture_24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.ithillel.lectures.lecture_24.db.HibernateSessionFactory;
import ua.ithillel.lectures.lecture_24.entity.Car;

import java.io.IOException;
import java.util.List;

public class CarDAO implements AbstractDAO<Car> {

    @Override
    public Car findById(int id) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Car.class, id);
        }
    }

    @Override
    public void save(Car entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Car entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(Car entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    @Override
    public List<Car> findAll() throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Car", Car.class).getResultList();
        }
    }
}


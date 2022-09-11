package ua.ithillel.lectures.lecture_24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.ithillel.lectures.lecture_24.db.HibernateSessionFactory;
import ua.ithillel.lectures.lecture_24.entity.Order;

import java.io.IOException;
import java.util.List;

public class OrderDAO implements AbstractDAO<Order> {
    @Override
    public Order findById(int id) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Order.class, id);
        }
    }

    @Override
    public void save(Order entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Order entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(Order entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    @Override
    public List<Order> findAll() throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Order", Order.class).getResultList();
        }
    }
}

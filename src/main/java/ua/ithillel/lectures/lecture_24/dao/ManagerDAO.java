package ua.ithillel.lectures.lecture_24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.ithillel.lectures.lecture_24.db.HibernateSessionFactory;
import ua.ithillel.lectures.lecture_24.entity.Manager;

import java.io.IOException;
import java.util.List;

public class ManagerDAO implements AbstractDAO<Manager> {
    @Override
    public Manager findById(int id) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Manager.class, id);
        }
    }

    @Override
    public void save(Manager entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Manager entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(Manager entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    @Override
    public List<Manager> findAll() throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Manager", Manager.class).getResultList();
        }
    }
}

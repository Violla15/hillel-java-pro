package ua.ithillel.lectures.lecture_24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.ithillel.lectures.lecture_24.db.HibernateSessionFactory;
import ua.ithillel.lectures.lecture_24.entity.Client;

import java.io.IOException;
import java.util.List;

public class ClientDAO implements AbstractDAO<Client> {
    @Override
    public Client findById(int id) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    @Override
    public void save(Client entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Client entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(Client entity) throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    @Override
    public List<Client> findAll() throws IOException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Client", Client.class).getResultList();
        }
    }
}


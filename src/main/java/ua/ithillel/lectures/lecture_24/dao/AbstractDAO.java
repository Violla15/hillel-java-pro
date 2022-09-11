package ua.ithillel.lectures.lecture_24.dao;

import java.io.IOException;
import java.util.List;

public interface AbstractDAO<T> {

    T findById(int id) throws IOException;

    void save(T entity) throws IOException;

    void update(T entity) throws IOException;

    void delete(T entity) throws IOException;

    List<T> findAll() throws IOException;
}

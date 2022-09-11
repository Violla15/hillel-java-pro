package ua.ithillel.lectures.lectute_23.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseObjectMapper <T>{

    T mapObject(ResultSet resultSet) throws SQLException;

    List<T> mapObjects(ResultSet resultSet) throws SQLException;

}

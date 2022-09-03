package ua.ithillel.homeworks.homework23.mapper;

import ua.ithillel.homeworks.homework23.entity.Manager;

import ua.ithillel.homeworks.homework23.entity.Role;
import ua.ithillel.lectures.lectute_23.mapper.DatabaseObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerMapper implements DatabaseObjectMapper<Manager> {
    @Override
    public Manager mapObject(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return mapManager(resultSet);
        }
        return new Manager();
    }

    @Override
    public List<Manager> mapObjects(ResultSet resultSet) throws SQLException {
        List<Manager> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(mapManager(resultSet));
        }
        return result;
    }

    private Manager mapManager(ResultSet resultSet) throws SQLException {
        Manager manager = new Manager();
        manager.setId(resultSet.getInt("id"));
        manager.setName(resultSet.getString("name"));
        manager.setLogin(resultSet.getString("login"));
        manager.setPassword(resultSet.getString("password"));
        manager.setEmail(resultSet.getString("email"));
        manager.setRole(Role.of(resultSet.getInt("role")));
        return manager;
    }
}

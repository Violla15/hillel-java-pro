package ua.ithillel.homeworks.homework23.mapper;


import ua.ithillel.homeworks.homework23.entity.Role;
import ua.ithillel.lectures.lectute_23.mapper.DatabaseObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleMapper implements DatabaseObjectMapper<Role> {

    @Override
    public Role mapObject(ResultSet resultSet) throws SQLException {
        Role role = null;
        if (resultSet.next()) {
            if (Role.ADMIN.getValue() == resultSet.getInt(1)) {
                return Role.ADMIN;
            } else if (Role.MANAGER.getValue() == resultSet.getInt(1)) {
                return Role.MANAGER;
            } else if (Role.CLIENT.getValue() == resultSet.getInt(1)) {
                return Role.CLIENT;
            }
        }
        return role;
    }

    @Override
    public List<Role> mapObjects(ResultSet resultSet) throws SQLException {

        List<Role> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(mapObject(resultSet));
        }
        return result;
    }
}

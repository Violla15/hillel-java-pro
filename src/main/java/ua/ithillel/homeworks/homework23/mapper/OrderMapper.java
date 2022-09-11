package ua.ithillel.homeworks.homework23.mapper;

import ua.ithillel.homeworks.homework23.entity.Order;
import ua.ithillel.lectures.lectute_23.mapper.DatabaseObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper implements DatabaseObjectMapper<Order> {

    @Override
    public Order mapObject(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return mapOrder(resultSet);
        }
        return new Order();
    }

    @Override
    public List<Order> mapObjects(ResultSet resultSet) throws SQLException {
        List<Order> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(mapOrder(resultSet));
        }
        return result;
    }

    private Order mapOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setDate(resultSet.getDate("date"));
        order.setCar_id(resultSet.getInt("car_id"));
        order.setClient_id(resultSet.getInt("client_id"));
        order.setManager_id(resultSet.getInt("manager_id"));
        return order;
    }
}

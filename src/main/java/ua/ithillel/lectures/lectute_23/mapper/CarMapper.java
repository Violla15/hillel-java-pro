package ua.ithillel.lectures.lectute_23.mapper;

import ua.ithillel.lectures.lectute_23.entity.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarMapper implements DatabaseObjectMapper<Car> {
    @Override
    public Car mapObject(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return mapCar(resultSet);
        }
        return new Car();
    }

    @Override
    public List<Car> mapObjects(ResultSet resultSet) throws SQLException {
        List<Car> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(mapCar(resultSet));
        }
        return result;
    }

    private Car mapCar(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setYear(resultSet.getInt("year"));
        car.setAvailable(resultSet.getBoolean("available"));
        car.setModel(resultSet.getString("model"));
        car.setManufacturer(resultSet.getString("manufacturer"));
        car.setPrice(resultSet.getInt("price"));
        return car;
    }

}

package ua.ithillel.homeworks.homework23;

import ua.ithillel.homeworks.homework23.entity.Manager;
import ua.ithillel.homeworks.homework23.entity.Order;
import ua.ithillel.homeworks.homework23.mapper.ManagerMapper;
import ua.ithillel.homeworks.homework23.mapper.OrderMapper;
import ua.ithillel.lectures.lectute_23.connection.DatabaseConfig;
import ua.ithillel.lectures.lectute_23.entity.Car;
import ua.ithillel.lectures.lectute_23.mapper.CarMapper;
import ua.ithillel.lectures.lectute_23.mapper.DatabaseObjectMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework23 {
    public static void main(String[] args) {

        DatabaseConfig config = new DatabaseConfig();
        try (Connection connection = config.getConnection();
             Statement statement = connection.createStatement()) {

            System.out.println(connection.getMetaData().getDatabaseProductName());

            // task - 1 //
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car_rent.managers WHERE role = 1;");
            DatabaseObjectMapper<Manager> mapperManager = new ManagerMapper();
            List<Manager> managers = mapperManager.mapObjects(resultSet);
            managers.forEach(System.out::println);


            // task - 2 //
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM car_rent.orders WHERE date >'2022-01-28';");
            DatabaseObjectMapper<Order> orderMapper = new OrderMapper();
            List<Order> orders = orderMapper.mapObjects(resultSet2);
            orders.forEach(System.out::println);

            // task - 3 //
            ResultSet resultSet3 = statement.executeQuery("SELECT *FROM car_rent.cars WHERE price IN (SELECT MAX(price) FROM car_rent.cars);");
            DatabaseObjectMapper<Car> carMapper = new CarMapper();
            Car car = carMapper.mapObject(resultSet3);
            System.out.println(car);

            // task - 4 //
            ResultSet resultSet4 = statement.executeQuery("SELECT * FROM car_rent.managers WHERE role = 2;");
            DatabaseObjectMapper<Manager> mapper = new ManagerMapper();
            List<Manager> roles = mapper.mapObjects(resultSet4);
            System.out.println("Count of managers with role 'Manager' - " + roles.size());


            // task - 5 //
            ResultSet resultSet5 = statement.executeQuery("SELECT * FROM car_rent.cars JOIN car_rent.orders ON orders.car_id = cars.id;");
            DatabaseObjectMapper<Car> carMapper2 = new CarMapper();
            List<Car> carOrders = carMapper2.mapObjects(resultSet5);
            for (Car c : carOrders)
                System.out.println(c.getManufacturer() + ", " + car.getModel());


            // task - 6//
            ResultSet resultSet6 = statement.executeQuery("SELECT * FROM car_rent.cars;");
            DatabaseObjectMapper<Car> carMapper6 = new CarMapper();
            List<Car> carList = carMapper6.mapObjects(resultSet6);
            Map<Integer, String> stringMap = new HashMap<>();
            int count = 1;
            for (Car x : carList) {
                if (!stringMap.containsValue(x.getManufacturer())) {
                    stringMap.put(count, x.getManufacturer());
                } else {
                    stringMap.put(count++, x.getManufacturer());
                }
            }
            System.out.println("Count  Manufacturer");
            for (Map.Entry<Integer, String> cars : stringMap.entrySet()) {
                System.out.println("  " + cars.getKey() + "   :   " + cars.getValue());
            }


            // task - 7//
            connection.setAutoCommit(false);
            Statement psInsert = connection.createStatement();
            psInsert.executeUpdate("INSERT INTO car_rent.orders (id, date, car_id,client_id, manager_id) VALUES (6, '20.08.2022', 10, 3, 2), (7, '13.06.2022', 6, 5, 4);");
            psInsert.executeUpdate("UPDATE car_rent.cars SET available = 'false' WHERE id = 6 AND id = 10;");
            connection.commit();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

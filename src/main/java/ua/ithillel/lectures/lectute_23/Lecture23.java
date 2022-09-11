package ua.ithillel.lectures.lectute_23;

import ua.ithillel.lectures.lectute_23.connection.DatabaseConfig;
import ua.ithillel.lectures.lectute_23.entity.Car;
import ua.ithillel.lectures.lectute_23.entity.Client;
import ua.ithillel.lectures.lectute_23.mapper.CarMapper;
import ua.ithillel.lectures.lectute_23.mapper.ClientMapper;
import ua.ithillel.lectures.lectute_23.mapper.DatabaseObjectMapper;

import java.sql.*;
import java.util.List;


public class Lecture23 {
    public static void main(String[] args) {
        DatabaseConfig config = new DatabaseConfig();
        try (Connection connection = config.getConnection();
             Statement statement = connection.createStatement()) {

            System.out.println(connection.getMetaData().getDatabaseProductName());

            // Statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car_rent.cars");

            DatabaseObjectMapper<Car> carMapper = new CarMapper();

            List<Car> cars = carMapper.mapObjects(resultSet);

            cars.forEach(System.out::println);

            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM car_rent.clients WHERE name = 'Jack'");
            DatabaseObjectMapper<Client> clientMapper = new ClientMapper();

            Client client = clientMapper.mapObject(resultSet1);
            System.out.println(client);

            // Prepared statement
            String preparedSql = "INSERT INTO car_rent.clients (id, name, surname, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedSql);
            preparedStatement.setInt(1, 9);
            preparedStatement.setString(2, "Oleksiy");
            preparedStatement.setString(3, "Pavlov");
            preparedStatement.setString(4, "890127398");

            int updatedRows = preparedStatement.executeUpdate();
            System.out.printf("%d rows added", updatedRows);

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package ua.ithillel.lectures.lectute_23.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/car_rent";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    private Connection connection;

    public DatabaseConfig() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }


}

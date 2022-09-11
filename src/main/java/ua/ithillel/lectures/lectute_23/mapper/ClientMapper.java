package ua.ithillel.lectures.lectute_23.mapper;

import ua.ithillel.lectures.lectute_23.entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientMapper implements  DatabaseObjectMapper<Client>{
    @Override
    public Client mapObject(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return mapClient(resultSet);
        }
        return new Client();
    }

    @Override
    public List<Client> mapObjects(ResultSet resultSet) throws SQLException {
        List<Client> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(mapClient(resultSet));
        }
        return result;
    }

    private Client mapClient(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getInt("id"));
        client.setName(resultSet.getString("name"));
        client.setSurname(resultSet.getString("surname"));
        client.setPhone(resultSet.getString("phone"));
        return client;
    }

}

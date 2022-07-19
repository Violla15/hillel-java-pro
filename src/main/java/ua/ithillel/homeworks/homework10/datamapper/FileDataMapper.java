package ua.ithillel.homeworks.homework10.datamapper;

import ua.ithillel.homeworks.homework10.exeption.UserNotFoundException;
import ua.ithillel.homeworks.homework10.user.Role;
import ua.ithillel.homeworks.homework10.user.User;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class FileDataMapper implements DataMapper {
    public final static String FILE = "src/main/java/ua/ithillel/homeworks/homework10/users.csv";
    static File file = new File(FILE);

    public static void getUsers(List<User> users) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String temp = "";
            for (int i = 0; i < file.length(); i++) {
                try {
                    temp = bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (temp == null)
                    break;
                String result = "";
                result += temp + System.lineSeparator();
                String[] usersArray = result.split("\\|");
                User user = new User(usersArray[0], usersArray[1], usersArray[2], usersArray[3], Role.getRoleByString(usersArray[4]));
                users.add(user);
            }
        } catch (UserNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserById(int id) throws UserNotFoundException {
        String idStr = String.valueOf(id);
        List<User> users = new ArrayList<>();
        getUsers(users);
        if (id == 0) {
            throw new IllegalArgumentException("User id  must not be null");
        }
        for (User user : users) {
            if (user.getId().equals(idStr)) {
                return user;
            }
        }
        throw new UserNotFoundException("User with id - " + id + " not found.");
    }

    @Override
    public User findUserByUsername(String userName) throws UserNotFoundException {
        List<User> users = new ArrayList<>();
        getUsers(users);
        if (userName == null) {
            throw new IllegalArgumentException("User name  must not be null");
        }
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        throw new UserNotFoundException("User with name - " + userName + " not found.");
    }

    @Override
    public User findUserByEmail(String email) throws UserNotFoundException {
        List<User> users = new ArrayList<>();
        getUsers(users);
        if (email == null) {
            throw new IllegalArgumentException("User email  must not be null");
        }
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new UserNotFoundException("User with email - " + email + " not found.");
    }

    @Override
    public List<User> findUsersByIds(List<Integer> ids) throws UserNotFoundException {
        List<User> users = new ArrayList<>();
        if (ids == null) {
            throw new IllegalArgumentException("List with id  must not be null");
        }
        for (Integer byId : ids) {
            users.add(findUserById(byId));
        }
        return users;
    }
}

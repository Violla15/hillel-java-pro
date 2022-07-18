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
    static List<User> users = new ArrayList<>();

    public static void fileReader() {
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
    public User findUserById(int id) {
        fileReader();
        String idStr = String.valueOf(id);
        for (User user : users)
            try {
                if (user.getId().equals(idStr)) {
                    return user;
                }
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        return null;
    }


    @Override
    public User findUserByUsername(String userName) {
        fileReader();
        for (User user : users)
            try {
                if (user.getUsername().equals(userName)) {
                    return user;
                }
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        fileReader();
        for (User user : users)
            try {
                if (user.getEmail().equals(email)) {
                    return user;
                }
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public List<User> findUsersByIds(List<Integer> ids) throws UserNotFoundException {
        List<User> users = new ArrayList<>();
        for (Integer byId : ids) {
            users.add(findUserById(byId));
        }
        return users;
    }
}

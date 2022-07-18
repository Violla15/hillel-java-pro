package ua.ithillel.homeworks.homework10.user;

import ua.ithillel.homeworks.homework10.exeption.UserNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataMapper implements DataMapper {
    public final static String FILE = "src/main/java/ua/ithillel/homeworks/homework10/users.csv";
    File file = new File(FILE);

    @Override
    public User findUserById(int id) throws UserNotFoundException {
        String idStr = String.valueOf(id);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String temp = "";
            for (int i = 0; i < file.length(); i++) {
                temp = bufferedReader.readLine();
                if (temp == null)
                    break;
                String result = "";
                result += temp + System.lineSeparator();
                String[] usersArray = result.split("\\|");
                for (String s : usersArray) {
                    if (usersArray[0].equals(idStr)) {
                        return new User(usersArray[0], usersArray[1], usersArray[2], usersArray[3], Role.getRoleByString(usersArray[4]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public User findUserByUsername(String userName) throws UserNotFoundException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String temp = "";
            for (int i = 0; i < file.length(); i++) {
                temp = bufferedReader.readLine();
                if (temp == null)
                    break;
                String result = "";
                result += temp + System.lineSeparator();
                String[] usersArray = result.split("\\|");
                for (String s : usersArray) {
                    if (usersArray[1].equals(userName)) {
                        return new User(usersArray[0], usersArray[1], usersArray[2], usersArray[3], Role.getRoleByString(usersArray[4]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserByEmail(String email) throws UserNotFoundException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String temp = "";
            for (int i = 0; i < file.length(); i++) {
                temp = bufferedReader.readLine();
                if (temp == null)
                    break;
                String result = "";
                result += temp + System.lineSeparator();
                String[] usersArray = result.split("\\|");
                for (String s : usersArray) {
                    if (usersArray[2].equals(email)) {
                        return new User(usersArray[0], usersArray[1], usersArray[2], usersArray[3], Role.getRoleByString(usersArray[4]));
                    }
                }
            }
        } catch (IOException e) {
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

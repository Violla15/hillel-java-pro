package ua.ithillel.homeworks.homework10;

import ua.ithillel.homeworks.homework10.exeption.UserNotFoundException;
import ua.ithillel.homeworks.homework10.user.FileDataMapper;

import java.util.ArrayList;
import java.util.List;

public class Homework10 {
    public static void main(String[] args)  {
        FileDataMapper fileDataMapper = new FileDataMapper();
        try {
            System.out.println("Fined user by id "+ fileDataMapper.findUserById(9));
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("Find user by name "+ fileDataMapper.findUserByUsername("Ivan Ivanov"));
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("Find user by email :" + fileDataMapper.findUserByEmail("kristiecole@quadeebo.com"));
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Integer>usersId = new ArrayList<>();
        usersId.add(7);
        usersId.add(5);
        usersId.add(2);
        try {
            System.out.println("Find users by id "+ fileDataMapper.findUsersByIds(usersId));
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

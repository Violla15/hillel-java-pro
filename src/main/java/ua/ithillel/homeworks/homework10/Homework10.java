package ua.ithillel.homeworks.homework10;

import ua.ithillel.homeworks.homework10.exeption.UserNotFoundException;
import ua.ithillel.homeworks.homework10.datamapper.FileDataMapper;

import java.util.ArrayList;
import java.util.List;

public class Homework10 {
    public static void main(String[] args) {
        FileDataMapper fileDataMapper = new FileDataMapper();

        System.out.println("Fined user by id " + fileDataMapper.findUserById(4));
        System.out.println("Find user by name " + fileDataMapper.findUserByUsername("Ivan Ivanov"));
        System.out.println("Find user by email :" + fileDataMapper.findUserByEmail("kristiecole@quadeebo.com"));

        List<Integer> usersId = new ArrayList<>();
        usersId.add(7);
        usersId.add(5);
        usersId.add(2);
        System.out.println("Find users by id " + fileDataMapper.findUsersByIds(usersId));
    }
}

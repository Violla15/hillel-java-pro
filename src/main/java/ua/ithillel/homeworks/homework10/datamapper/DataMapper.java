package ua.ithillel.homeworks.homework10.datamapper;

import ua.ithillel.homeworks.homework10.exeption.UserNotFoundException;
import ua.ithillel.homeworks.homework10.user.User;

import java.util.List;

public interface DataMapper {
    User findUserById(int id) throws UserNotFoundException;

    User findUserByUsername(String userName) throws UserNotFoundException;

    User findUserByEmail(String email) throws UserNotFoundException;

    List<User> findUsersByIds(List<Integer> ids) throws UserNotFoundException;
}

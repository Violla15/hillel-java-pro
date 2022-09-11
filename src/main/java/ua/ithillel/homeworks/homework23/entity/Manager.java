package ua.ithillel.homeworks.homework23.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Manager {

    private int id;
    private String name;
    private String login;
    private String password;
    private String email;
    private Role role;

}

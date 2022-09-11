package ua.ithillel.lectures.lecture_24.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "managers")
public class Manager {

    @Id
    private int id;
    private String name;
    private String login;
    private String password;
    private String email;

    @Enumerated
    private Role role;

    @OneToMany
    @JoinColumn(name = "manager_id")
    private List<Order> orders;

    @Override
    public String toString() {
        return "Manager{" +
                "id - " + id +
                ", name - '" + name + '\'' +
                ", login - '" + login + '\'' +
                ", password - '" + password + '\'' +
                ", email  - '" + email + '\'' +
                ", role - " + role +
                '}';
    }
}


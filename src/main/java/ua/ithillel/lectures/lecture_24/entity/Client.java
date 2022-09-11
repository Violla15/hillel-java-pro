package ua.ithillel.lectures.lecture_24.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clients")

public class Client {

    @Id
    private int id;
    private String name;
    private String surname;
    private String phone;

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<Order> orders;

    @Override
    public String toString() {
        return "Client {" +
                "id - " + id +
                ", name - '" + name + '\'' +
                ", surname - '" + surname + '\'' +
                ", phone - '" + phone + '\'' +
                ", orders - " + orders +
                '}';
    }
}

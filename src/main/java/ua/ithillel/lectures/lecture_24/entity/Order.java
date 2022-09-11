package ua.ithillel.lectures.lecture_24.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private int id;
    private Date date;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Override
    public String toString() {
        return "Order{" +
                "id - " + id +
                ", date - " + date +
                ", car - " + car.getId() +
                ", client - " + client.getId() +
                ", manager - " + manager.getId() +
                '}';
    }
}


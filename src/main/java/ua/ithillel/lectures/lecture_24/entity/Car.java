package ua.ithillel.lectures.lecture_24.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "id")
    private int id;
    private String manufacturer;
    private String model;
    private int year;
    private int price;
    private boolean available;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private List<Order> orders;


    @Override
    public String toString() {
        return "Car {" +
                "id - " + id +
                ", manufacturer - '" + manufacturer + '\'' +
                ", model - '" + model + '\'' +
                ", year - " + year +
                ", price - " + price +
                ", available - " + available +
                '}';
    }
}






package ua.ithillel.homeworks.homework23.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Order {

    private int id;
    private Date date;
    private int car_id;
    private int client_id;
    private int manager_id;

}

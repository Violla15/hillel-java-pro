package ua.ithillel.homeworks.homework18.entity;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
@XmlSeeAlso(Car.class)
@XmlType(propOrder = {"country", "city", "street", "house"})
public class Location {

    private String country;
    private String city;
    private String street;
    private long house;
}
package ua.ithillel.homeworks.homework18.entity;

import jakarta.xml.bind.annotation.*;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
@XmlRootElement
@XmlType(propOrder = {"name", "milesPerGallon", "cylinders", "displacement", "horsepower", "year", "origin", "location"})
public class Car extends CarsWrapper {

    private String name;
    private long milesPerGallon;
    private long cylinders;
    private long displacement;
    private long horsepower;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date year;
    private Origin origin;
    private Location location;

}



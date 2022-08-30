package ua.ithillel.homeworks.homework17.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class Person {
    private String name;
    private String surname;
    private int age;
    private String country;
}

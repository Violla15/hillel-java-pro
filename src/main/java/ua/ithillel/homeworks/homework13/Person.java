package ua.ithillel.homeworks.homework13;

import ua.ithillel.homeworks.homework13.annotation.XmlElement;
import ua.ithillel.homeworks.homework13.annotation.XmlSerializable;

@XmlSerializable(key = "Person")
public class Person {

    @XmlElement(key = "firstName")
    private String name;
    @XmlElement(key = "lastName")
    private String surName;
    @XmlElement
    private String address;

    public Person(String name, String surName, String address) {
        this.name = name;
        this.surName = surName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

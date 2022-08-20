package ua.ithillel.homeworks.homework18.entity;

import jakarta.xml.bind.annotation.XmlEnum;
import lombok.Getter;

@XmlEnum
@Getter

public enum Origin {
    EUROPE, USA;
}

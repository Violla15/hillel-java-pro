package ua.ithillel.homeworks.homework23.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Role {


    ADMIN(1),
    MANAGER(2),
    CLIENT(3);

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Role of(int value) {
        for (Role e : values()) {
            if (value == e.value) {
                return e;
            }
        }
        return null;
    }

}




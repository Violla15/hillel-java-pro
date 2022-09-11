package ua.ithillel.lectures.lecture_24.entity;

import lombok.Getter;

@Getter

public enum Role {
    ADMIN(1),
    MANAGER(2),
    CLIENT(3);

    private final int value;

    Role(int value) {
        this.value = value;
    }
}

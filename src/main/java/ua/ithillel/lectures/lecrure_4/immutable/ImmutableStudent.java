package ua.ithillel.lectures.lecrure_4.immutable;

import java.util.Arrays;

public final class ImmutableStudent {
    private final String name;
    private final String email;
    private final String[] groups;

    public ImmutableStudent(String name, String email, String[] groups) {
        this.name = name;
        this.email = email;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String[] getGroup() {
        String[] arrayCopy = new String[this.groups.length];
        for (int i = 0; i < groups.length; i++) {
            arrayCopy[i] = groups[i];
        }
        return arrayCopy;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}

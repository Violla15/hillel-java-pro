package ua.ithillel.homeworks.homework4.immutable;

import java.util.Arrays;

public final class ImmutableStudent {
    private final String name;
    private final String email;
    private final String[] group;

    public ImmutableStudent(String name, String email, String[] group) {
        this.name = name;
        this.email = email;
        this.group = group;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String[] getGroup() {
        String[] arraysCopy = new  String[this.group.length];
        System.arraycopy(group,0,arraysCopy,0,group.length);
        return group;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", group=" + Arrays.toString(group) +
                '}';
    }
}

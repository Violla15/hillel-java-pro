package ua.ithillel.homeworks.homework10.user;

import ua.ithillel.homeworks.homework10.user.Role;

public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    private final Role role;

    public User(String id, String username, String email, String password, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setName(String s) {
        for (Role role1 : Role.values())
            if (role.name().equalsIgnoreCase(s)) {
                break;
            }
    }

    @Override
    public String toString() {
        return "\nUser " + getUsername() + " , with id - " + getId() + ", email: " + getEmail() +
                ", password: " + getPassword() + ", role: " + getRole();
    }
}

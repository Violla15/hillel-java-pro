package ua.ithillel.homeworks.homework10.user;

public enum Role {
    QA("QA\r\n"),
    Developer("Developer\r\n"),
    CEO("CEO\r\n"),
    Manager("Manager\r\n");
    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getUrl() {
        return role;
    }

    public static Role getRoleByString(String role) {
        for (Role r : values()) {
            if (r.getUrl().equalsIgnoreCase(role)) {
                return r;
            }
        }
        throw new IllegalArgumentException("No enum found with role : [" + role + "]");
    }
}


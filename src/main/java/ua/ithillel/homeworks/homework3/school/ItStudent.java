package ua.ithillel.homeworks.homework3.school;

public class ItStudent extends SchoolMember {

    public ItStudent(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student : " + name + '\n' + "Group - " + getGroups();
    }
}

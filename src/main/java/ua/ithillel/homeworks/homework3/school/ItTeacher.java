package ua.ithillel.homeworks.homework3.school;

public class ItTeacher extends SchoolMember {

    protected int experience;

    public ItTeacher(String name, String surname, int age, String email, int experience) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Teacher : " + name + '\n' + "Group -" + getGroups();
    }
}
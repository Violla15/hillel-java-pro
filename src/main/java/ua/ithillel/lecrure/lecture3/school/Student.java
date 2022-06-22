package ua.ithillel.lecrure.lecture3.school;

import java.util.List;

public class Student extends SchoolMember {
    private List<String> groups;
    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "groups=" + groups +
                '}';
    }
}

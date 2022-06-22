package ua.ithillel.homeworks.homework3.school;

import java.util.List;

public class SchoolMember {
    protected String name;
    protected String surname;
    protected int age;
    protected String email;
    public List<StudyGroup> groups;

    public void setGroups(List<StudyGroup> groups) {
        this.groups = groups;
    }

    public List<StudyGroup> getGroups() {
        return groups;
    }
}

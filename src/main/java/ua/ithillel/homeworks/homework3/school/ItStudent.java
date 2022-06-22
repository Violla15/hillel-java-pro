package ua.ithillel.homeworks.homework3.school;
import java.util.List;

public class ItStudent {
    protected String name;
    protected String surname;
    protected int age;
    protected String email;
    public List<StudyGroup> studyGroups;

    public ItStudent(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public void setStudyGroups(List<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public List<StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    @Override
    public String toString() {
        return "Student : " + name + '\n' + "Group - " + getStudyGroups();
    }
}

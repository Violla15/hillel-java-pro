package ua.ithillel.homeworks.homework3.school;
import java.util.List;

public class ItTeacher {
    protected String name;
    protected String surname;
    protected int age;
    protected String email;
    protected int experience;
    private List<StudyGroup> studyGroups;

    public ItTeacher(String name, String surname, int age, String email, int experience) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.experience = experience;
    }

    public void setStudyGroups(List<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public List<StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    @Override
    public String toString() {
        return "Teacher : " + name + '\n' + "Group -" + getStudyGroups();
    }
}
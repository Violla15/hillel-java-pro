package ua.ithillel.homeworks.homework3.school;

public class StudyGroup {

    protected String nameGroup;
    protected int year;
    protected int maxStudent;
    protected int periodOfStudy;
    protected String learningFormat;

    public StudyGroup(String nameGroup, int year, int maxStudent, int periodOfStudy, String learningFormat) {
        this.nameGroup = nameGroup;
        this.year = year;
        this.maxStudent = maxStudent;
        this.periodOfStudy = periodOfStudy;
        this.learningFormat = learningFormat;
    }

    @Override
    public String toString() {
        return nameGroup;
    }
}

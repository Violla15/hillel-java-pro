package ua.ithillel.lectures.lecture_3.school;

public class Teacher extends SchoolMember{

    private int experience;
    public Teacher() {

    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "experience=" + experience +
                '}';
    }
}
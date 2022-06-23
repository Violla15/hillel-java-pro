package ua.ithillel.homeworks.homework3;

import ua.ithillel.homeworks.homework3.school.ItStudent;
import ua.ithillel.homeworks.homework3.school.ItTeacher;
import ua.ithillel.homeworks.homework3.school.SchoolMember;
import ua.ithillel.homeworks.homework3.school.StudyGroup;

import java.util.ArrayList;
import java.util.List;

public class Homework3 {
    public static void main(String[] args) {
        StudyGroup studyGroup1 = new StudyGroup("Java Elementary (PROGRAMMING)", 2022, 20, 4, "online");
        StudyGroup studyGroup2 = new StudyGroup("QA (TESTING)", 2022, 15, 6, "online");
        StudyGroup studyGroup3 = new StudyGroup("Python", 2022, 13, 8, "offline");

        ItStudent student1 = new ItStudent("Oleg", "Oleinik", 25, "oleinik@gmail.com");
        student1.setGroups(List.of(studyGroup1));

        ItStudent student2 = new ItStudent("Ivan", "Ivanov", 30, "Ivanov@gmail.com");
        student2.setGroups(List.of(studyGroup2, studyGroup1));

        ItTeacher teacher1 = new ItTeacher("Stepan", "Petrov", 31, "Petrov@gmail.com", 4);
        teacher1.setGroups(List.of(studyGroup1, studyGroup3));

        ItTeacher teacher2 = new ItTeacher("Nikolay", "Pavlov", 27, "Pavlov@gmail.com", 5);
        teacher2.setGroups(List.of(studyGroup2));

        List<SchoolMember> studyGroups = new ArrayList<>();
        studyGroups.add(teacher1);
        studyGroups.add(teacher2);
        studyGroups.add(student1);
        studyGroups.add(student2);

        sowGroups(List.of(teacher1));
        sowGroups(List.of(teacher2));
        sowGroups(List.of(student1));
        sowGroups(List.of(student2));
    }

    public static void sowGroups(List<SchoolMember> studyGroups) {
        for (SchoolMember schoolMember : studyGroups) {
            System.out.println(schoolMember);
        }
    }
}

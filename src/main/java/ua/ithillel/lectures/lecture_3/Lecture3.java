package ua.ithillel.lectures.lecture_3;

import ua.ithillel.lectures.lecture_3.school.Student;
import ua.ithillel.lectures.lecture_3.school.Teacher;

public class Lecture3 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Oleg");
        student.setSurname("Oleinik");
        student.setAge(25);
        student.setEmail("oleinik@gmail.com");
        System.out.println("Student - " + student);


        Teacher teacher = new Teacher();
        teacher.setName("Ivan");
        teacher.setSurname("Ivanov");
        teacher.setAge(30);
        teacher.setEmail("Ivanov@gmail.com");
        teacher.setExperience(4);
        System.out.println("Teacher - "+ teacher);
    }
}

package ua.ithillel.lectures.lecture_8;

import ua.ithillel.lectures.lecture_8.hashMap.Employee;
import ua.ithillel.lectures.lecture_8.tree.Tree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lecture8 {
    public static void main(String[] args) {
        maps();

        mapEqualsHashCod();

        tree();
    }

    private static void tree() {
        Tree root = new Tree(5);
        Tree rootLeft = new Tree(7);
        Tree rootRight = new Tree(9);


        Tree rootLeftLeft = new Tree(10);
        Tree rootLeftRight = new Tree(6);

        Tree rootRightRight = new Tree(1);

        rootRightRight.setRight(new Tree(2));
        rootRightRight.setLeft(new Tree(3));
        rootRight.setRight(rootRightRight);

        rootLeft.setLeft(rootLeftLeft);
        rootLeft.setRight(rootLeftRight);

        root.setLeft(rootLeft);
        root.setRight(rootRight);

        System.out.println("Sum is : " + root.sum());
    }

    private static void mapEqualsHashCod() {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(1);

        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());

        Map<Employee, String> employeeMap = new HashMap<>();
        employeeMap.put(employee1, "Jack");
        employeeMap.put(employee2, "Nick");
    }

    private static void maps() {
        Map<String, Integer> exampleMap = new HashMap<>();
        String a = "a";
        String b = "b";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        exampleMap.put("a", 1);

        Map<String, String> birthdayMap = new HashMap<>();
        birthdayMap.put("Oleg", "09.04.2002");
        birthdayMap.put("Igor", "07.05.2001");
        birthdayMap.put("Kate", "09.08.1998");

        System.out.println("HashMap entries : ");
        for (Map.Entry<String, String> entry : birthdayMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        Map<String, String> birthdayLinkedHashMap = new LinkedHashMap<>();
        birthdayLinkedHashMap.put("Oleg", "09.04.2002");
        birthdayLinkedHashMap.put("Igor", "07.05.2001");
        birthdayLinkedHashMap.put("Kate", "09.08.1998");

        System.out.println("HashMap entries : ");
        for (Map.Entry<String, String> entry : birthdayLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

package ua.ithillel.homeworks.homework7;

import ua.ithillel.homeworks.homework7.list.IntLinkedList;


public class Homework7 {
    public static void main(String[] args) {
        IntLinkedList intLinkedList = new IntLinkedList();
        System.out.println("Added operation : ");
        intLinkedList.add(5);
        intLinkedList.add(4);
        intLinkedList.add(3);
        intLinkedList.add(2);
        intLinkedList.add(7);
        System.out.println(intLinkedList);

        System.out.println("Size - " + intLinkedList.size() + " elements ");

        System.out.println("Removed operation : ");
        intLinkedList.remove(2);
        System.out.println(intLinkedList.removeByValue(2));
        System.out.println(intLinkedList);

      System.out.println("SubList : " + intLinkedList.subList(1, 3));
    }
}

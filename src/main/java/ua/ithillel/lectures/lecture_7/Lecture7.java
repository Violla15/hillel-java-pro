package ua.ithillel.lectures.lecture_7;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lecture7 {
    public static void main(String[] args) {
        iterators();

        list();

        queues();

        set();

    }

    private static void set() {
        Set<String> mySet = new HashSet<>();
        mySet.add("d");
        mySet.add("b");
        mySet.add("c");
        mySet.add("a");
        mySet.add("c");

        System.out.println("My set = " + mySet);

        Set<String> myLinkedSet = new HashSet<>();
        myLinkedSet.add("d");
        myLinkedSet.add("b");
        myLinkedSet.add("c");
        myLinkedSet.add("a");
        myLinkedSet.add("c");

        System.out.println("My linked set = " + myLinkedSet);

        SortedSet<Integer> sortedSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });

        sortedSet.add(1);
        sortedSet.add(2);
        sortedSet.add(3);

        System.out.println("Sorted set = "+ sortedSet);

    }

    private static void queues() {
        Queue<String> queue = new LinkedList<>();
        queue.add("Cherry");
        queue.add("banana");
        queue.add("apple");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll() + "");
        }

        Queue<String> deQueue = new PriorityQueue<>();
        deQueue.add("cherry");
        deQueue.add("banana");
        deQueue.add("apple");

        while (!deQueue.isEmpty()) {
            System.out.println(deQueue.poll());
        }
    }

    private static void list() {
        List<String> myArrayList = new ArrayList<>();
        List<String> myLinkedList = new LinkedList<>();

        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        for (String str : myArrayList) {
            System.out.println(str);
        }
        System.out.println("contains a :" + myArrayList.contains("a"));
    }

    private static void iterators() {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("next = " + next);

            if (next.equals(2)) {
                numbers.remove(2);
            }
        }
        System.out.println(numbers);

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.add(4);
        copyOnWriteArrayList.add(5);

        Iterator<Integer> iterator2 = copyOnWriteArrayList.iterator();

        while (iterator2.hasNext()) {
            Integer next = iterator2.next();
            System.out.println(next);

            if (next.equals(2)) {
                copyOnWriteArrayList.add(55);
                copyOnWriteArrayList.remove(2);
            }

        }
        System.out.println(copyOnWriteArrayList);

    }
}

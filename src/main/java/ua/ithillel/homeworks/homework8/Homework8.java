package ua.ithillel.homeworks.homework8;

import java.util.*;

public class Homework8 {
    public static void main(String[] args) {

        countDuplicates(50);                    // task 1

        Node root = new Node("Root");          // task 2
        Node node1 = new Node("Node 1");
        Node node2 = new Node("Node 2");
        Node node3 = new Node("Node 3");

        root.add(node1);
        root.add(node2);
        root.add(node3);
        node1.add(new Node("Node 1.1"));
        node1.add(new Node("Node 1.2"));
        node2.add(new Node("Node 2.1"));
        node3.add(new Node("Node 3.1"));

        Node nodeToInsert1 = new Node("Node 1.3");
        Node nodeToInsert2 = new Node("Node 3.2");

        root.insert(nodeToInsert1, "Node 1");
        root.insert(nodeToInsert2, "Node 3");
        System.out.println("\n Tree hierarchy : \n");

        root.printAsAHierarchy(0);
    }

    public static void countDuplicates(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i <= size; i++) {
            randomNumbers.add(random.nextInt(0, 100));
        }
        System.out.println(randomNumbers);

        Map<Integer, Integer> counter = new HashMap<>();
        for (int x : randomNumbers) {
            if (!counter.containsKey(x)) {
                counter.put(x, 1);
            } else {
                counter.put(x, counter.get(x) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() >= 2) {
                System.out.println("Number  " + entry.getKey() + "  repeats : " + entry.getValue() + " times");
            }
        }
    }
}


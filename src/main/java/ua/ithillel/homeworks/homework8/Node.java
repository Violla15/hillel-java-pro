package ua.ithillel.homeworks.homework8;

import java.util.*;
import java.util.ArrayList;

public class Node {
    private final String name;
    private List<Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(Node a) {
        this.children.add(a);
    }

    public void printAsAHierarchy(int node) {
        for (int i = 0; i < node; i++) System.out.print("--->  ");
        System.out.println(this.name);
        for (Node child : this.children) {
            child.printAsAHierarchy(node + 1);
        }
    }

    public void insert(Node newNode, String parentName) {
        for (Node child : this.children) {
            if (parentName.equals(child.name)) {
                child.add(newNode);
                break;
            }
        }
    }
}

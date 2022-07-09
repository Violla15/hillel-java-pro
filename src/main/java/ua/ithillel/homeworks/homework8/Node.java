package ua.ithillel.homeworks.homework8;

import java.util.*;
import java.util.ArrayList;

public class Node {
    private final String name;
    private List children;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<Node>();
    }

    public void add(Node a) {
        this.children.add(a);
    }

    public void printAsAHierarchy(int node) {
        for (int i = 0; i < node; i++) System.out.print("--->  ");
        System.out.println(this.name);
        for (Object child : this.children) {
            Node a = (Node) child;
            a.printAsAHierarchy(node + 1 );
        }
    }

    public void insert(Node newNode, String parentName) {
        for (Object child : this.children) {
            Node a = (Node) child;
            if (parentName.equals(a.name)) {
                a.add(newNode);
                break;
            }
        }
    }
}

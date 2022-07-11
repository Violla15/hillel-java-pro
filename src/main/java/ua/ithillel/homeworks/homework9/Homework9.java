package ua.ithillel.homeworks.homework9;

import static ua.ithillel.homeworks.homework9.TreeNode.*;

public class Homework9 {
    public static void main(String[] args) {
        System.out.println("Fibonacci number from 10 is - " + fibonacci(10)); // task -1

        resultMergingTrees();                                                    // task - 2
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void resultMergingTrees() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNodeLeft1 = new TreeNode(3);
        TreeNode treeNodeRight1 = new TreeNode(2);

        treeNode1.setLeft(treeNodeLeft1);
        treeNode1.setRight(treeNodeRight1);
        treeNodeLeft1.setLeft(new TreeNode(5));

        System.out.println("\nFirst binary tree ( left --> root --> right ) :");
        treeTraversal(treeNode1);

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNodeLeft2 = new TreeNode(1);
        TreeNode treeNodeRight2 = new TreeNode(3);

        treeNode2.setLeft(treeNodeLeft2);
        treeNode2.setRight(treeNodeRight2);
        treeNodeLeft2.setRight(new TreeNode(4));
        treeNodeRight2.setRight(new TreeNode(7));

        System.out.println("\nSecond binary tree ( left --> root --> right ):");
        treeTraversal(treeNode2);

        TreeNode result = new TreeNode();
        result = mergeTrees(treeNode1, treeNode2);

        System.out.println("\nResult of merging binary trees ( left --> root --> right ):");
        treeTraversal(result);
    }
}

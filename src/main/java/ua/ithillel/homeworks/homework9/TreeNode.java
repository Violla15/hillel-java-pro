package ua.ithillel.homeworks.homework9;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode t = new TreeNode(t1.getVal() + t2.getVal());
        t.setLeft(mergeTrees(t1.getLeft(), t2.getLeft()));
        t.setRight(mergeTrees(t1.getRight(), t2.getRight()));
        return t;
    }

    static class Trunk {
        Trunk prev;
        String string;

        Trunk(Trunk prev, String string) {
            this.prev = prev;
            this.string = string ;
        }
    }

    public static void showTrunks(Trunk p) {
        if (p == null) {
            return;
        }
        showTrunks(p.prev);
        System.out.print(p.string);
    }

    public static void printTree(TreeNode root, Trunk prev, boolean isLeft) {
        if (root == null) {
            return;
        }
        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);
        printTree(root.right, trunk, true);
        if (prev == null) {
            trunk.string = "———";
        } else if (isLeft) {
            trunk.string = ".———";
            prev_str = "   |";
        } else {
            trunk.string = "`———";
            prev.string = prev_str;
        }
        showTrunks(trunk);
        System.out.println(" " + root.val);
        if (prev != null) {
            prev.string = prev_str;
        }
        trunk.string = "   |";
        printTree(root.left, trunk, false);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

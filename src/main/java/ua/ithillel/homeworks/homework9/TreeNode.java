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

    public static void treeTraversal(TreeNode node) {
        if (node != null) {
            treeTraversal(node.left);
            System.out.print(node.val + " ---> ");
            treeTraversal(node.right);
        }
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

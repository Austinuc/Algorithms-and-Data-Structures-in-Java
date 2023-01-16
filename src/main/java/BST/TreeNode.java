package BST;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
 }
    @Override
    public String toString() {
        return printInOrder(this, new StringBuilder());
    }
    public String printInOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return "";

        printInOrder(root.left,sb);
        sb.append(root.val).append(", ");
        printInOrder(root.right, sb);

        return sb.substring(0, sb.toString().length()-2);
    }
}

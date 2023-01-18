package BST;

import java.util.ArrayDeque;

/**
 * Problem: Give an algorithm for inserting an element into binary tree.
 *
 * Solution: Since the given tree is a binary tree, we can insert the element wherever we want. To
 * insert an element, we can use the level order traversal or any traversal method and insert the element wherever we find
 * the node whose left or right child is NULL.
 */
public class Insert {

    /**
     * This method follows the BST insertion rule. If the input root Tree is a BST, its BST property is preserved after insertion
     *
     * @param root given input tree
     * @param value to insert
     * @return the root node
     */
    public TreeNode insertNodeRecursively(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);

        if (root.val >= value) //Assuming duplicates are allowed
            insertNodeRecursively(root.left, value);
        else insertNodeRecursively(root.right, value);

        return root;
    }

    /**
     * This method does not follow the BST insertion rule.
     * It inserts a node to the tree using Level Order traversal.
     *
     * It only produces a nearly complete or a complete binary tree if the input tree is a balanced tree.
     *
     * @param root given input tree
     * @param value to insert
     * @return root node
     */
    public TreeNode insertNodeIteratively(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode ptr;
        while (!queue.isEmpty()) {
            ptr = queue.pollFirst();

            if (ptr.left == null) {
                ptr.left = new TreeNode(value);
                break;
            }
            if (ptr.right == null) {
                ptr.right = new TreeNode(value);
                break;
            }

            queue.addLast(ptr.left);
            queue.addLast(ptr.right);
        }


        return root;
    }

    public static void main(String[] args) {
        int[] unsorted = {8,4,1,6,3,9,7};
        Insert insert = new Insert();
        TreeNode root = null;
        for(int a : unsorted) {
            root = insert.insertNodeIteratively(root, a);
        }

        System.out.println(root);
    }
}

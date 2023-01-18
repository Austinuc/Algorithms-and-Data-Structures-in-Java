package BST;

import java.awt.*;
import java.util.ArrayDeque;

public class DeleteNode {

    /**
     * <h2>This implementation is for a BST.</h2>
     *
     * <h4>Considers 3 cases</h4>
     * <ol>
     *     <li>When the node to be deleted has only one child. Then it simply returns the child</li>
     *     <li>The above also takes care of leaf nodes. It simply returns NULL</li>
     *     <li>If node has both children, find the smallest value leaf node of its right subtree and swap, deleting
     *          the leaf node afterwards
     *     </li>
     * </ol>
     *
     * @param root node
     * @param item to be deleted
     * @return modified root tree
     */
    public TreeNode deleteNode(TreeNode root, int item) {
        if (root == null) return null;

        if (root.val == item) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root.right);
            TreeNode temp = root.right;
            while (!queue.isEmpty()) { //Get the smallest node of the right child for replacement
                temp = queue.pollFirst();

                //Since this is a BST, the smallest value lies in the leftmost subtree
                if (temp.left != null)
                    queue.addLast(temp.left);
            }
            root.val = temp.val;
            root.right = deleteNode(root.right, root.val);
        }

        if (root.val > item)
            root.left = deleteNode(root.left, item);
        else root.right = deleteNode(root.right, item);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(new int[] {2,3,4,5,7,9,11,20,25,41,50,69});
        System.out.println(root);
        DeleteNode delete = new DeleteNode();
        delete.deleteNode(root, 5);
        delete.deleteNode(root, 11);
        delete.deleteNode(root, 3);
        delete.deleteNode(root, 4);
        delete.deleteNode(root, 9);
        delete.deleteNode(root, 25);
        delete.deleteNode(root, 41);
        delete.deleteNode(root, 20);
        delete.deleteNode(root, 50);
        delete.deleteNode(root, 7);
        delete.deleteNode(root, 2);
        delete.deleteNode(root, 69);
        System.out.println(root);
    }
}

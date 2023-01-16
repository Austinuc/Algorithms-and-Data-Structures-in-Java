package BST;

import java.util.ArrayDeque;

/**
 * <h3>Recursive and Iterative implementations of the major Tree traversals</h3>
 * <ul>
 *     <li>PreOrder Traversal</li>
 *     <li>InOrder Traversal</li>
 *     <li>PostOrder Traversal</li>
 *     <li>Level Order Traversal</li>
 * </ul>
 */
public class Traversals {


    /**
     * Pre Order:
     * <ol>
     *     <li>Process root node</li>
     *     <li>Traverse left child</li>
     *     <li>Traverse right child</li>
     * </ol>
     * @param root given tree
     */
    public void preOrderRecursive(TreeNode root) {
        if (root == null) return;
        //Process current node
        System.out.println(root.val);

        //Traverse children
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public void preOrderIterative(TreeNode root) {
        if (root == null) return;
        TreeNode ptr = root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while (true) {

            while(ptr != null) {
                //Process current node
                System.out.println(ptr.val);

                // Add to stack after processing
                stack.add(ptr);

                //Go to left child
                ptr = ptr.left;
            }

            if (stack.isEmpty()) break;
            //Left children are traversed get the parent nodes
            ptr = stack.pollLast();

            //now get the right child of the parent and continue
            ptr = ptr.right;
        }
    }

    /**
     * In Order:
     * <ol>
     *     <li>Traverse left child</li>
     *     <li>Process root node</li>
     *     <li>Traverse right child</li>
     * </ol>
     * @param root given tree
     */
    public void inOrderRecursive(TreeNode root) {
        if (root == null) return;

        //Traverse left child
        preOrderRecursive(root.left);

        //Process root node
        System.out.println(root.val);

        //Traverse right child
        preOrderRecursive(root.right);
    }

    public void inOrderIterative(TreeNode root) {
        if (root == null) return;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode ptr = root;

        while (true) {

            while(ptr != null) {
                stack.add(ptr);
                ptr = ptr.left;
            }

            if (stack.isEmpty()) break;

            ptr = stack.pollLast();
            //Process current latest node added to stack
            System.out.println(ptr.val);

            //Traverse its right child
            ptr = ptr.right;
        }

    }

    /**
     * Post Order:
     * <ol>
     *     <li>Traverse left child</li>
     *     <li>Traverse right child</li>
     *     <li>Process root node</li>
     * </ol>
     * @param root given tree
     */
    public void postOrderRecursive(TreeNode root) {
        if (root == null) return;

        //Traverse left child
        preOrderRecursive(root.left);

        //Traverse right child
        preOrderRecursive(root.right);

        //Process root node
        System.out.println(root.val);
    }

    public void postOrderIterative(TreeNode root) {

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode ptr = root, prev = null;

        do {
            while(ptr != null) {
                stack.add(ptr);
                ptr = ptr.left;
            }

            while(ptr == null && !stack.isEmpty()) {
                ptr = stack.peekLast();
                //process node only on 2nd traversal or when node is a leaf node
                if (ptr.right == null || ptr.right.equals(prev)) {
                    //Process current node
                    System.out.println(ptr.val);
                    prev = ptr;

                    //Then remove processed node from stack
                    stack.pollLast();
                } else { //else process right subtree
                    ptr = ptr.right;
                }
            }
        } while (!stack.isEmpty());

    }

    /**
     * <ol>
     *     <li>Firstly, Add root to queue</li>
     *     <li>Remove first node from queue and process the node </li>
     *     <li>Add children to queue if they exists</li>
     *     <li>Repeat </li>
     * </ol>
     * @param root
     */
    public void levelOrderIterative(TreeNode root) {
        if (root == null) return;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode ptr;
        queue.addLast(root);

        while (!queue.isEmpty()) {
            ptr = queue.pollFirst();

            //Process current node
            System.out.println(ptr.val);

            //Add children nodes to queue if they exist

            if (ptr.left != null)
                queue.addLast(ptr.left);
            if (ptr.right != null)
                queue.addLast(ptr.right);
        }
    }
}

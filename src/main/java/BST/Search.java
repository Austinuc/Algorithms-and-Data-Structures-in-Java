package BST;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 *
 * ADDITION: Non BST implementation is also given.
 */
public class Search {


    /**
     * Recursive solution
     * Time Complexity O(logn).
     * Space: O(1)
     * @param root given BST
     * @param val to be found
     * @return subTree if found or null
     */
    public TreeNode searchBSTRecursively(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val)
            return searchBSTRecursively(root.left, val);
        else
            return searchBSTRecursively(root.right, val);
    }

    /**
     * BST Iterative solution
     * @param root given binary tree
     * @param val search value
     * @return subtree if found or null otherwise
     */
    public TreeNode searchBSTIteratively(TreeNode root, int val) {

        TreeNode ptr = root;

        while (ptr != null) {
            if (ptr.val < val) {
                ptr = ptr.right;
            } else if (ptr.val > val) {
                ptr = ptr.left;
            } else {
                break;
            }
        }

        return ptr;
    }

    /**
     * Non BST Recursive solution. Using PreOrder traversal
     * @param root given binary tree
     * @param value search value
     * @return subtree if found or null otherwise
     */
    public TreeNode searchNonBSTRecursively(TreeNode root, int value) {
        if (root == null) return null;

        //Check root
        if (root.val == value) {
            return root;
        }
        //search the left subtree
        TreeNode temp = searchNonBSTRecursively(root.left, value);
        if (temp == null) //if not found, search right subtree
            return searchNonBSTRecursively(root.right, value);
        else return temp;
    }

    public static void main(String[] args) {
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(new int[] {2,3,4,5,7,9,11,69});
        System.out.println(new Search().searchNonBSTRecursively(root, 5));
    }

}

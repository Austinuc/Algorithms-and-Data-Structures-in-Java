package BST;

/**
 * In java, assigning any reference type to null automatically deletes its value.
 * So simple re-assigning any root node to null deletes the tree.
 *
 * The implementation below is just to show how it can be done should there be no garbage collector
 */
public class DeleteTree {

    public TreeNode deleteTree(TreeNode root) {
        if (root == null) return null;

        root.left = deleteTree(root.left);
        root.right = deleteTree(root.right);

        //Free the root node here for languages without garbage collector

        return null;

    }

    public static void main(String[] args) {
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(new int[] {2,3,4,5,7,9,11,69});
        System.out.println(root);
        new DeleteTree().deleteTree(root);
        System.out.println(root);
    }
}

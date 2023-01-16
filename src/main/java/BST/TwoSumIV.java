package BST;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {
    Set<Integer> elements = new HashSet<>();
    int nodeCount = 0;
    boolean found = false;

    //Solution is for a general BT
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        nodeCount++;
        if (elements.contains(k - root.val) && nodeCount > 1) {
            found = true;
            return true;
        }
        elements.add(root.val);
        findTarget(root.left, k);
        findTarget(root.right, k);

        return found;
    }

    public static void main(String[] args) {
        TwoSumIV test = new TwoSumIV();
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(new int[] {2,3});

        System.out.println(test.findTarget(root, 6));
    }
}

package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

public class RootToLeafPathSumEqualToK {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        int k = 8;
        System.out.println(root_to_leaf_path_sum_equal_to_k(root, k)); // Expected output: true
    }

    static Boolean root_to_leaf_path_sum_equal_to_k(TreeNode root, Integer k) {
        return helper(root, k, 0L);
    }

    // Time Complexity: O(n) where n is the number of nodes in the tree. We may visit each node once.
    // Space Complexity: O(h) where h is the height of the tree due to recursive call stack. In worst case (skewed tree), space is O(n). In best case
    static boolean helper(TreeNode root, Integer k, long runningSum){

        if(root == null)
            return false;

        //process ROOT
        runningSum = runningSum + root.val;

        // If we are at a leaf node, check if the running sum equals k. If it does, we found a valid path, so return true.
        if(root.left == null && root.right == null && runningSum == k)
            return true;

        // Recur for left and right subtrees. If either subtree returns true, we have found a valid path, so return true.
        return (helper(root.left, k, runningSum) || helper(root.right, k, runningSum));
    }
}

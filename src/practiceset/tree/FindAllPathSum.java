package practiceset.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the
 * values along the path equals targetSum. A leaf is a node with no children.
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * */
public class FindAllPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<Integer> slate = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        findAllPathSum(root,targetSum,0,slate,result);

        System.out.println(result);
    }

    static void findAllPathSum(TreeNode root, int targetSum, int runningSum, List<Integer> slate, List<List<Integer>> result) {

        // Base case: if we reached a null node, return false as we cannot form a valid path.
        if (root == null) {
            return;
        }

        // Update the running sum with the current node's value
        runningSum += root.val;
        slate.add(root.val);

        // Check if we are at a leaf node and if the running sum equals targetSum
        if (root.left == null && root.right == null) {
            if (runningSum == targetSum) {
                // We found a valid path, add a copy of the current path (slate) to the result list
                result.add(new ArrayList<>(slate));
            }
        }

        // Recursively check left and right subtrees
        findAllPathSum(root.left, targetSum, runningSum, slate, result);
        findAllPathSum(root.right, targetSum, runningSum, slate, result);

        // Backtrack: remove the current node from the path before returning to explore other paths
        slate.remove(slate.size() - 1);

    }
}

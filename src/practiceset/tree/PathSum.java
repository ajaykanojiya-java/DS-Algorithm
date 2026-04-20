package practiceset.tree;

/*
* Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the
* values along the path equals targetSum. A leaf is a node with no children.
* Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
* Output: true
* Explanation: The root-to-leaf path with the target sum is shown.
* */
public class PathSum {
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
        System.out.println(hasPathSum(root, targetSum,0));
    }

    // T(n) = O(n) where n is the number of nodes in the tree. We are visiting each node once.
    static boolean hasPathSum(TreeNode root, int targetSum, int runningSum) {

        // Base case: if we reached a null node, return false as we cannot form a valid path.
        if (root == null) {
            return false;
        }

        // Update the running sum with the current node's value
        runningSum += root.val;

        // Check if we are at a leaf node and if the running sum equals targetSum
        if (root.left == null && root.right == null) {
            return (runningSum == targetSum);
        }

        // Recursively check left and right subtrees
        return hasPathSum(root.left, targetSum, runningSum) || hasPathSum(root.right, targetSum, runningSum);

    }
}

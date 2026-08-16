package practiceset.tree.assignment;

import com.sun.source.tree.Tree;
import practiceset.tree.TreeNode;

public class CloneABinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode clonedRoot = clone_binary_tree(root);
        System.out.println("Cloned binary tree created successfully.");
    }
    // Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
    // Space Complexity: O(n) in worst case (skewed tree) due to recursive call stack.
    // In best case (balanced tree), space complexity is O(log n) due to recursive call stack.
    static TreeNode clone_binary_tree(TreeNode root) {
        if(root == null)
            return null;

        // Create a new node with the same value as the root
        TreeNode clonedTree = new TreeNode(root.val);

        // Recursively clone the left and right subtrees
        clonedTree.left = clone_binary_tree(root.left);
        clonedTree.right = clone_binary_tree(root.right);

        return clonedTree;
    }

}

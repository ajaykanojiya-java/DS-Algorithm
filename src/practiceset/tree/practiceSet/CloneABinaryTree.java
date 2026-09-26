package practiceset.tree.practiceSet;

import practiceset.tree.TreeNode;

public class CloneABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        cloneBinaryTree(root);
    }

    // Given a binary tree, clone the binary tree and return the root of the cloned tree.
    //Time complexity: O(n), where n is the number of nodes in the binary tree.
    //space complexity: O(h), where h is the height of the binary tree.
    private static void cloneBinaryTree(TreeNode root){
        printInorder(root);
        TreeNode clonedTree = helper(root);
        printInorder(clonedTree);
    }
    // Helper method to recursively clone the binary tree
    private static TreeNode helper(TreeNode root){
        if(root == null)
            return null;

        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = helper(root.left);
        newRoot.right = helper(root.right);
        return newRoot;
    }
    private static void printInorder(TreeNode root){
        if(root == null)
            return;

        System.out.print(" "+root.val);
        printInorder(root.left);
        printInorder(root.right);
    }
}

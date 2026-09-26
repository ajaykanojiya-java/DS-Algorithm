package practiceset.tree.practiceSet;

import practiceset.tree.TreeNode;

/*
Mirror Image of a Binary Tree
Given a binary tree, find the mirror image of the tree.
 */
public class MirrorImageOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        mirrorImage(root);
    }

    //Time complexity: O(n), where n is the number of nodes in the binary tree.
    //space complexity: O(h), where h is the height of the binary tree.
    private static void mirrorImage(TreeNode root){
        printInorder(root);
        helper(root);
        System.out.println("\n");
        printInorder(root);
    }

    //Time complexity: O(n), where n is the number of nodes in the binary tree.
    //space complexity: O(h), where h is the height of the binary tree.
    //helper method to recursively find the mirror image of the binary tree
    private static void helper(TreeNode root){
        if(root == null)
            return;

        //swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //recurse left
        helper(root.left);
        //recurse right
        helper(root.right);
    }
    private static void printInorder(TreeNode root){
        if(root == null)
            return;

        System.out.print(" "+root.val);
        printInorder(root.left);
        printInorder(root.right);
    }
}

package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

public class SearchANodeInBinarySearchTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(search_node_in_bst(root, 2)); // Expected output: true
        System.out.println(search_node_in_bst(root, 5)); // Expected output: false
    }
    static Boolean search_node_in_bst(TreeNode root, Integer value) {
        if(root == null) {
            return false;
        }
        if(root.val == value) {
            return true;
        }
        if(value < root.val) {
            return search_node_in_bst(root.left, value);
        } else {
            return search_node_in_bst(root.right, value);
        }
    }
}

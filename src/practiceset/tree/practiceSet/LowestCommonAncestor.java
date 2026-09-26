package practiceset.tree.practiceSet;

import practiceset.tree.TreeNode;

/*
Lowest Common Ancestor of a Binary Tree
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as
descendants (where we allow a node to be a descendant of itself).
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(6);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = a;
        root.right = new TreeNode(5);
        root.right.left = b;
        root.right.right = new TreeNode(7);
        System.out.println(lca(root,a,b));
    }

    private static int lca(TreeNode root, TreeNode a, TreeNode b){
        TreeNode lca = helper(root,a,b);
        return lca.val;
    }

    //helper method to find the lowest common ancestor of two nodes in a binary tree
    //Time complexity: O(n), where n is the number of nodes in the binary tree.
    //space complexity: O(h), where h is the height of the binary tree.
    private static TreeNode helper(TreeNode root, TreeNode a, TreeNode b){
        if(root == null)
            return null;

        //found one of the node
        if(root.val == a.val || root.val == b.val)
            return root;

        //recurse left
        TreeNode left = helper(root.left,a,b);
        //recurse right
        TreeNode right = helper(root.right,a,b);

        //if both left and right are not null, then the current root is the lowest common ancestor
        if(left != null && right != null)
            return root;

        //if one of them is null, return the other one
        return (left != null ? left : right);
    }
}

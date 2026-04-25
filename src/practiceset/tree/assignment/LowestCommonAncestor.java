package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

/*
*   Lowest Common Ancestor (LCA) of a Binary Tree
*  Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
*   The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
* (where we allow a node to be a descendant of itself).
* */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode a = root.left.left;
        TreeNode b =  root.left.right;

        TreeNode lca = helper(root, a, b);
        System.out.println((lca!= null? lca.val : null)); // Expected output: 2
    }

    // Time Complexity: O(n) where n is the number of nodes in the tree. We may visit each node once.
    static TreeNode helper(TreeNode root, TreeNode a, TreeNode b) {
        //base case
        if (root == null) {
            return null;
        }

        // If we found either a or b, return that node to parent call.
        if((root.val == a.val) || (root.val == b.val))
            return root;


        //Recurse LEFT
        TreeNode left = helper(root.left, a, b);

        //Recurse RIGHT
        TreeNode right = helper(root.right, a, b);

        // If both left and right are not null, it means a and b are found in different subtrees, so current node is LCA.
        if(left != null && right != null)
            return root;

        // If one of them is null, return the non-null child (which could be either left or right).
        return (left != null) ? left : right;
    }
}

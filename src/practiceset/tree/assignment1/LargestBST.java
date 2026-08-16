package practiceset.tree.assignment1;

import practiceset.tree.TreeNode;
/*
You are given a Binary Tree, not necessarily a BST. So The largest subtree which itself is a valid BST. And return its size (number of nodes).
Key Observation
At every node we need to know:
1. Is left subtree BST?
2. Is right subtree BST?
3. Size of BST
4. Maximum value in left subtree
5. Minimum value in right subtree
left.max < root.value < right.min
Because BST condition is:
          10
         /  \
        5    15
       / \   / \
      1   8 7  20
Is entire tree a BST? Left subtree max = 8, Right subtree min = 7
Rule: All nodes in right subtree > root but 7 < 10
 */
public class LargestBST {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        System.out.println("Size of the largest BST is: " + find_largest_bst(root));
    }
    static Integer find_largest_bst(TreeNode root) {
        return helper(root).size;
    }

    // This method checks if the subtree rooted at the given node is a valid BST and returns its size, minimum value, and maximum value.
    static NodeInfo helper(TreeNode root) {

        if(root == null)
            return new NodeInfo(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);

        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);

        // Check if the current subtree is a valid BST
        if(left.isBST && right.isBST && left.max < root.val && root.val < right.min) {

            int size = left.size + right.size + 1;
            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);
            return new NodeInfo(true, size, min, max);
        }

        return new NodeInfo(false, Math.max(left.size, right.size),0,0);
    }

    // This class represents information about a subtree, including whether it is a valid BST, its size, and
    // its minimum and maximum values.
    static class NodeInfo {

        boolean isBST;
        int size;
        int min;
        int max;

        NodeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}

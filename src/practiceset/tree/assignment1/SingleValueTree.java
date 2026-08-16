package practiceset.tree.assignment1;

import practiceset.tree.TreeNode;

/*
    * A single value tree is a tree where all the nodes have the same value.
    * Given a binary tree, count the number of single value subtrees.
    * A subtree is a single value subtree if all the nodes in that subtree have the same value.
    *
    * Example:
    * Input: root = [5,1,5,5,5,null,5]
    * Output: 4
    * Explanation: There are 4 single value subtrees: [5], [5], [5], [5].
    *
    * Input: root = [1,1,1,1,1,null,1]
    * Output: 6
    * Explanation: There are 6 single value subtrees: [1], [1], [1], [1], [1], [1].
 */
public class SingleValueTree {
    static int count = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println("Count of single value subtrees: " + find_single_value_trees(root));
    }

    static Integer find_single_value_trees(TreeNode root) {

        isUnival(root);
        return count;
    }

    //solution is post order traversal
    static boolean isUnival(TreeNode root) {
        if(root == null)
            return true;

        //recurse left
        boolean left = isUnival(root.left);

        //recurse right
        boolean right = isUnival(root.right);

        if(!left || !right)
            return false;

        //process root
        if(root.left != null && root.left.val != root.val)
            return false;
        if(root.right != null && root.right.val == root.val)
            return false;
        count++;
        return true;
    }
}

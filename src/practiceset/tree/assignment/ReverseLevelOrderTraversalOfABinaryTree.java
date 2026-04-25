package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// Given a binary tree, return the reverse level order traversal of its nodes values. (i.e., from left to right, level by level from leaf to root).
public class ReverseLevelOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        reverse_level_order_traversal(root);//output: [[4, 5], [2, 3], [1]]
    }

    // Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
    // Space Complexity: O(n) in worst case (skewed tree) due to
    static ArrayList<ArrayList<Integer>> reverse_level_order_traversal(TreeNode root) {
        //base case
        if(root == null)
            return null;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> levelList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        // Process nodes level by level until queue is empty
        while(!queue.isEmpty()){

            int size = queue.size();

            //process level by level
            for(int i=0; i<size; i++){

                //1. Pop
                TreeNode node = queue.poll();

                //2. process
                levelList.add(node.val);

                //3. Add children
                if(node.left  != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }

            // After processing all nodes at the current level, add the level list to result and reset level list for next level.
            result.add(new ArrayList<>(levelList));
            levelList = new ArrayList<>();
        }
        // Reverse the result list to get reverse level order traversal (from bottom to top).
        Collections.reverse(result);
        return result;
    }
}

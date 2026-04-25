package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// Given a binary tree, return the right side view of it. The right side view of a binary tree is the set of nodes visible when the tree is viewed from the right side.
public class RightSideViewOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(right_view(root)); // Expected output: [1, 3, 4]
    }

    // Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
    // Space Complexity: O(n) in worst case (skewed tree) due to queue usage. In best case (balanced tree), space is O(width of the tree).
    static ArrayList<Integer> right_view(TreeNode root) {

        //base case
        if(root == null)
            return null;

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> levelList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        // Process nodes level by level until queue is empty
        while(!queue.isEmpty()){

            int size = queue.size();
            // Process all nodes at the current level
            for(int i=0; i<size; i++){

                //1. Pop
                TreeNode node = queue.poll();

                //2. Process
                levelList.add(node.val);

                //3. Add Children
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }

            // After processing all nodes at the current level, add the last element of levelList to result (which is the rightmost node of that level) and reset levelList for next level.
            result.add(levelList.get(levelList.size()-1));
            levelList = new ArrayList<>();
        }
        return result;
    }
}

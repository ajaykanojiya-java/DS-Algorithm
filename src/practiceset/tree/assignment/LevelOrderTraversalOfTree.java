package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        ArrayList<ArrayList<Integer>> result = level_order_traversal(root);
        System.out.println(result); // Expected output: [[1], [2, 3], [4, 5]]

        levelOrderTraversal(root); // Expected output: 1 2 3 4 5
    }

    // Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
    // Space Complexity: O(n) in worst case (skewed tree) due to queue usage. In best case (balanced tree), space is O(width of the tree).
    static ArrayList<ArrayList<Integer>> level_order_traversal(TreeNode root) {

        //base case
        if (root == null)
            return null;

        ArrayList<Integer> levelList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        //Start with root node in the queue
        queue.offer(root);

        // Process nodes level by level until queue is empty
        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                //1. Pop
                TreeNode node = queue.poll();

                //2. Process
                levelList.add(node.val);

                //3. Add children
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            // After processing all nodes at the current level, add the level list to result and reset level list for next level.
            result.add(new ArrayList<>(levelList));
            levelList = new ArrayList<>();
        }

        return result;
    }


    // Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
    // Space Complexity: O(n) in worst case (skewed tree) due to queue usage. In best case (balanced tree), space is O(width of the tree).
    static void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null)
                queue.offer(node.left);

            if (node.right != null)
                queue.offer(node.right);
        }
    }
}

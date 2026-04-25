package practiceset.tree.assignment;

import practiceset.tree.TernaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
*   Given a ternary tree, return the level order traversal of its nodes values. (ie, from left to right, level by level).
* */
public class LevelOrderTraversalOfANTree {

    public static void main(String[] args) {
            TernaryTreeNode root = new TernaryTreeNode(1);
            root.children.add(new TernaryTreeNode(2));
            root.children.add(new TernaryTreeNode(3));
            root.children.add(new TernaryTreeNode(4));
            root.children.get(0).children.add(new TernaryTreeNode(5));
            root.children.get(0).children.add(new TernaryTreeNode(6));
            root.children.get(1).children.add(new TernaryTreeNode(7));
            root.children.get(1).children.add(new TernaryTreeNode(8));
            root.children.get(2).children.add(new TernaryTreeNode(9));
            root.children.get(2).children.add(new TernaryTreeNode(10));

            System.out.println(levelOrderTraversal(root)); // Expected output: [[1], [2, 3, 4], [5, 6, 7, 8, 9, 10]]
    }

    // Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
    // Space Complexity: O(n) in worst case (skewed tree) due to queue usage. In best case (balanced tree), space is O(width of the tree).
    static ArrayList<ArrayList<Integer>> levelOrderTraversal(TernaryTreeNode root) {
        //base case
        if(root == null)
            return null;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> levelList = new ArrayList<>();
        Queue<TernaryTreeNode> queue = new LinkedList<>();

        //Add root node
        queue.offer(root);

        // Process nodes level by level until queue is empty
        while(!queue.isEmpty()){
            int size = queue.size();

            // Process all nodes at the current level
            for(int i=0; i<size;i++){

                //1. Pop
                TernaryTreeNode node = queue.poll();

                //2. Process
                levelList.add(node.value);

                //3. Add children
                for(TernaryTreeNode child : node.children){
                    queue.offer(child);
                }
            }
            // After processing all nodes at the current level, add the level list to result and reset level list for next level.
            result.add(new ArrayList<>(levelList));
            levelList = new ArrayList<>();
        }
        return result;
    }
}

package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigzagLevelOrderTraversalOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(zigzag_level_order_traversal(root));// Expected output: [[1], [3, 2], [5, 4]]
    }

    static ArrayList<ArrayList<Integer>> zigzag_level_order_traversal(TreeNode root) {

        if(root == null)
            return null;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> levelList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int levelCounter = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            levelCounter++;
            //process level by level
            for(int i=0; i<size; i++){

                //1. Pop
                TreeNode node = queue.poll();

                //2. Process
                levelList.add(node.val);

                //3. Add children
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }

            if(levelCounter%2 == 0)
                Collections.reverse(levelList);

            result.add(new ArrayList<>(levelList));
            levelList = new ArrayList<>();
        }
        return result;
    }
}

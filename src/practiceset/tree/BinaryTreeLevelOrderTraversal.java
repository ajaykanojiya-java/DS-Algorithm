package practiceset.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*  This is a level order traversal of binary tree. We can use queue to process level by level.
* We will keep track of size of queue at each level and process that many nodes at that level.
* We will add children of those nodes to the queue and repeat the process until queue is empty.
* Time complexity: O(n) where n is number of nodes in the tree. We are processing each node once.
* Space complexity: O(n) in worst case when tree is completely balanced, and we have n/2 nodes at the last level.
* In best case when tree is skewed, space complexity is

* T(n) = O(n)
* Aux S(n) = O(n) if balanced; O(1) if skewed
* Output S(n) = O(n)
*/
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        //Input: root = [3,9,20,null,null,15,7]
        //Output: [[3],[9,20],[15,7]]

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        System.out.println(obj.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelList = null;

        //process level by level
        while(!queue.isEmpty()){

            int size = queue.size();
            levelList = new ArrayList<>();

            //process each node at level
            for(int i=0; i<size; i++){

                //Step: 1 Pop element
                TreeNode node = queue.poll();

                // Step 2: process element
                levelList.add(node.val);

                //Step 3: add children
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(levelList);
        }
        return result;
    }
}

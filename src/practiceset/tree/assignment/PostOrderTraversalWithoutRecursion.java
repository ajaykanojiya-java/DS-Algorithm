package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalWithoutRecursion {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ArrayList<Integer> result = postOrderTraversal(root);
        System.out.println(result);// Expected output: [4, 5, 2, 3, 1]
    }

    // Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
    // Space Complexity: O(n) in worst case (skewed tree) due to stack usage. In best case (balanced tree), space is O(log n).
    static ArrayList<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        //base case
        if(root == null)
            return result;

        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();

        stack1.push(root);

        // Process all nodes in stack1 and push them to stack2 in a way that left children are processed before right children.
        while(!stack1.isEmpty()){
            //pop element
            TreeNode node = stack1.pop();
            stack2.push(node);

            //process left
            if(node.left != null)
                stack1.push(node.left);

            //push right
            if(node.right != null)
                stack1.push(node.right);
        }

        // Now stack2 has nodes in reverse post-order (root, right, left). Pop from stack2 to get correct post-order (left, right, root).
        while(!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }
        return result;
    }
}

package practiceset.tree.practiceSet;

import practiceset.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalWithoutRecursion {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(postOrderTraversal(root));
    }

    private static ArrayList<Integer> postOrderTraversal(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left != null)
                stack1.push(node.left);
            if(node.right != null)
                stack1.push(node.right);
        }
        while(!stack2.isEmpty())
            result.add(stack2.pop().val);
        return result;
    }
}

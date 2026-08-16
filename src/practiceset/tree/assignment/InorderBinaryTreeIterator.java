package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class InorderBinaryTreeIterator {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(100);
        root.right = new TreeNode(200);
        root.right.left = new TreeNode(300);

        ArrayList<String> operations = new ArrayList<>();
        operations.add("hasNext");
        operations.add("next");
        operations.add("hasNext");
        operations.add("next");
        operations.add("hasNext");
        operations.add("next");
        operations.add("hasNext");

        ArrayList<Integer> result = implement_tree_iterator(root, operations);
        System.out.println(result); // Expected output: [1, 100, 1, 200, 1, 300, 0]
    }
    static ArrayList<Integer> implement_tree_iterator(TreeNode root, ArrayList<String> operations) {

        TreeIterator iterator = new TreeIterator(root);

        ArrayList<Integer> result = new ArrayList<>();

        for(String op : operations) {
            if(op.equals("next")) {
                result.add(iterator.next());
            }
            else {
                result.add(iterator.hasNext());
            }
        }
        return result;
    }

    // Time Complexity: O(n) where n is the number of nodes in the tree. Each node is pushed and popped from the stack at most once.
    // Space Complexity: O(h) where h is the height of the tree. In the
    static class TreeIterator {

        private Stack<TreeNode> stack;

        // Constructor initializes the stack and pushes all left children of the root onto the stack.
        public TreeIterator(TreeNode root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        // Helper method to push all left children of a given node onto the stack.
        private void pushLeft(TreeNode node) {

            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        // Returns 1 if there are more nodes to visit (i.e., the stack is not empty), otherwise returns 0.
        public int hasNext() {
            return stack.isEmpty() ? 0 : 1;
        }

        // Returns the next node's value in the inorder traversal.
        public int next() {
            if(stack.isEmpty()) {
                return 0;
            }

            TreeNode current = stack.pop();
            if(current.right != null) {
                pushLeft(current.right);
            }
            return current.val;
        }
    }
}

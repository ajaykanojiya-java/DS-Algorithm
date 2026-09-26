package practiceset.tree.assignment1;

import practiceset.tree.TreeNode;

public class IsItABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        System.out.println(isTreeBinaryTree(root));
    }

    private static boolean isTreeBinaryTree(TreeNode root){
        return inorder(root,0);
    }
    private static boolean inorder(TreeNode root, int prev){
        if(root == null)
            return true;

        //recurse left
        if(!inorder(root.left, prev))
            return false;

        //process root
        if(prev > root.val)
            return false;
        prev = root.val;

        //recurse right
        return inorder(root.right,prev);
    }
}

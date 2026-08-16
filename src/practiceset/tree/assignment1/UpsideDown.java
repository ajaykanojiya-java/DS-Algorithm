package practiceset.tree.assignment1;

import practiceset.tree.TreeNode;
/*
    * Given a binary tree, turn it upside down and return the new root.
    * You can turn a binary tree upside down with the following rules:
    * The original left child becomes the new root.
    * The original root becomes the new right child.
    * The original right child becomes the new left child.
    *
    * Example:
    * Input: root = [1,2,3,4,5]
    * Output: [4,5,2,null,null,3,1]
    *
    * oldRight becomes newLeft
    * oldRoot  becomes newRight
    * 1
     / \
    2   3
    * 2
     / \
    3   1
 */
public class UpsideDown {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        printTree(root);
        System.out.println("\nUpside down tree: ");
        TreeNode upsideDownRoot = upsideDownBinaryTree(root);
        printTree(upsideDownRoot);
    }

    //helper method to print the tree in level order
    static TreeNode upsideDownBinaryTree(TreeNode root){
        //base case
        if(root == null || root.left == null)
            return root;

        TreeNode upsideDownRootNode = upsideDownBinaryTree(root.left);

        //oldRight becomes newLeft
        root.left.left = root.right;

        //oldRoot  becomes newRight
        root.left.right = root;

        //remove the old pointer;
        root.left = null;
        root.right = null;

        return upsideDownRootNode;
    }

    static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}

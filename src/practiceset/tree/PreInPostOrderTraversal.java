package practiceset.tree;

public class PreInPostOrderTraversal {
    public static void main(String[] args) {
        //Input: root = [1,null,2,3]
        //Output: [1,2,3]

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print("Preorder Traversal: ");
        preOrder(root);
        System.out.print("\nInorder Traversal: ");
        inorder(root);
        System.out.print("\nPostorder Traversal: ");
        postOrder(root);
    }

    public static void preOrder(TreeNode root) {
        if(root == null)
            return;

        //1. process the node
        System.out.print(root.val + " ");

        //2. process left subtree
        preOrder(root.left);

        //3. process right subtree
        preOrder(root.right);
    }

    public static void inorder(TreeNode root) {
        if(root == null)
            return;

        //1. process left subtree
        preOrder(root.left);

        //2. process the node
        System.out.print(root.val + " ");

        //3. process right subtree
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if(root == null)
            return;

        //1. process left subtree
        preOrder(root.left);

        //2. process right subtree
        preOrder(root.right);

        //3. process the node
        System.out.print(root.val + " ");
    }
}

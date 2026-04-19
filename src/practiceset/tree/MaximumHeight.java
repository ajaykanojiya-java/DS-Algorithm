package practiceset.tree;

public class MaximumHeight {
    public static void main(String[] args) {
        //Input: root = [3,9,20,null,null,15,7]
        //output: 3

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(15);
        root.left.right = new TreeNode(7);

        System.out.println(maxHeight(root));
    }

    public static int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }
}

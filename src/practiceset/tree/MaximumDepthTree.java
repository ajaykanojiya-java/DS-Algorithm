package practiceset.tree;

public class MaximumDepthTree {
    public static void main(String[] args) {
        //Input: root = [3,9,20,null,null,15,7]
        //output: 3

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(15);
        root.left.right = new TreeNode(7);

        System.out.println(maxDepth(root));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }

}

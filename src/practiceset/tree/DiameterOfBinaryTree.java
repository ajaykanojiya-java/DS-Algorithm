package practiceset.tree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        //Input: root = [1,2,3,4,5]
        //Output: 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.right = new TreeNode(3);

        System.out.println(diameterOfBinaryTree(root));
        inorder(root);
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        //depth(root);
        getHeight(root);
        return diameter;
    }


    public static int getHeight(TreeNode root){

        //base case
        if(root == null)
            return -1;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        int d = lh + rh + 2;

        if(d>diameter)
            diameter = d;

        return (Math.max (lh,rh) + 1);

    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // Update diameter at this node
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return depth of this node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void inorder(TreeNode root){
        if(root == null)
            return;


        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

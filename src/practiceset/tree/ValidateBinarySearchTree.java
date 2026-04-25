package practiceset.tree;

// Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//Time complexity: O(n) where n is the number of nodes in the tree. We are visiting each node once.
//Space complexity: O(h) where h is the height of the tree.
// In the worst case, the height of the tree can be equal to the number of nodes (O(n)) in the case of a skewed tree, and
// In the best case, it can be O(log n) for a balanced tree.
public class ValidateBinarySearchTree {

    static Integer prev = null;

    public static void main(String[] args) {
        // Input: root = [10,5,15,null,null,6,20]
        // Output: true

        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(6);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(20);

        System.out.println(isValidBSTInorder(root));
        System.out.println(isValidBSTPreorder(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isValidBSTPreorder1(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isValidBSTPostorder(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    //Think like this: if we do an inorder traversal of a binary search tree, we will get the nodes in sorted order.
    // So, we can check if the values are in increasing order. root.val <= prev means that the current node's value is less than or equal to the previous node's value,
    // which violates the property of a binary search tree.
    // Inorder traversal, LEFT-ROOT-RIGHT
    static boolean isValidBSTInorder(TreeNode root) {

        //base case
        if(root == null)
            return true;

        //1.Recurse LEFT
        if(!isValidBSTInorder(root.left))
            return false;

        //2. ROOT, process root node
        if (prev!=null && root.val <= prev)
            return false;
        prev = root.val;

        //3. Recurse RIGHT
        return isValidBSTInorder(root.right);
    }

    // In preorder traversal, ROOT-LEFT-RIGHT
    static boolean isValidBSTPreorder(TreeNode root, int min, int max){

        //base case
        if(root == null)
            return true;

        // The current node's value must be greater than the minimum value and less than the maximum value to satisfy the properties of a binary search tree.
        return min < root.val && root.val < max
                // Recursively check the left subtree with an updated maximum value (the current node's value) and the right subtree with an updated minimum value (the current node's value).
                && isValidBSTPreorder(root.left, min, root.val)
                && isValidBSTPreorder(root.right, root.val, max);
    }

    // Preorder traversal, ROOT-LEFT-RIGHT
    static boolean isValidBSTPreorder1(TreeNode root, int min, int max){

        //base case
        if(root == null)
            return true;

        //1. ROOT, process root node
        if (!(min < root.val && root.val < max))
            return false;

        //2. Recurse LEFT
        if(!isValidBSTPreorder(root.left, min,root.val))
            return false;

        //3. Recurse RIGHT
        if(!isValidBSTPreorder(root.right, root.val, max))
            return false;

        return true;
    }

    // Postorder traversal, LEFT-RIGHT-ROOT
    static boolean isValidBSTPostorder(TreeNode root, int min, int max){

        //base case
        if(root == null)
            return true;

        //1. Recurse LEFT
        if(!isValidBSTPostorder(root.left, min,root.val))
            return false;

        //2. Recurse RIGHT
        if(!isValidBSTPostorder(root.right, root.val, max))
            return false;

        //3. ROOT, process root node
        return min < root.val && root.val < max;
    }
}

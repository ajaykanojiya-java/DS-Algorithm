package practiceset.tree;

import java.util.ArrayList;
import java.util.List;

public class BalancedBSTFromASortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(-10);
        nums.add(-3);
        nums.add(0);
        nums.add(5);
        nums.add(9);
        System.out.println(nums);
        TreeNode root = build_balanced_bst(nums);
        inOrderTraversal(root);
    }

    static TreeNode build_balanced_bst(ArrayList<Integer> a) {
        // Write your code here.
        int low = 0;
        int high = a.size()-1;
        TreeNode root = buildBST(a,low, high);
        return root;
    }

    static TreeNode buildBST(ArrayList<Integer> a, int low, int high){
        if(low > high)
            return null;

        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left = buildBST(a, low, mid-1);
        node.right = buildBST(a, mid+1, high);
        return node;
    }

    static void inOrderTraversal(TreeNode node){
        if(node == null)
            return;

        //1. Recurse LEFT node
        inOrderTraversal(node.left);

        //2. add element into the result
        System.out.println(node.val);

        //3. Recurse RIGHT node
        inOrderTraversal(node.right);
    }
}

package practiceset.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementOfBST {
    public static void main(String[] args) {
        //Input: root = [3,1,4,null,2], k = 1
        //Output: 1

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;
        System.out.println(kth_smallest_element(root, k));
    }

    static Integer kth_smallest_element(TreeNode root, Integer k) {
        // Write your code here.
        int count = 0;
        List<Integer> kthSmallest = new ArrayList<>();
        inorder(root,k,count,kthSmallest);
        return kthSmallest.getFirst();
    }

    //This is the efficient way to find kth the smallest element in BST, as it will traverse the tree in inorder and
    // keep track of the count of nodes visited and when count is equal to k, it will add the node value to the list and return.
    public static void inorder(TreeNode root, int k, int count, List<Integer> kthSmallest) {
        //base case
        if (root == null) {
            return;
        }

        //1. process left subtree
        inorder(root.left, k, count, kthSmallest);

        //2. process the node
        if(count == k){
            kthSmallest.add(root.val);
            return;
        }
        count++;

        //3. process right subtree
        inorder(root.right, k, count, kthSmallest);
    }

    //this is another way to find kth the smallest element in BST, but it is not efficient as
    // it will traverse the whole tree and store all the elements in a list and then return the kth element from the list.
    static void inorderTraversal(TreeNode node, List<Integer> result){

        if(node == null)
            return;

        //1. Recurse LEFT node
        inorderTraversal(node.left,result);

        //2. add element into the result
        result.add(node.val);

        //3. Recurse RIGHT node
        inorderTraversal(node.right,result);
    }

}

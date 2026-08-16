package practiceset.tree.assignment1;

import practiceset.tree.TreeNode;

import java.util.ArrayList;

/*
    * Given two binary search trees, merge them into a single binary search tree.
    * The merged tree should contain all the nodes from both trees and maintain the binary search tree property.
    *
    * Example:
    * Input: root1 = [3,1,5], root2 = [4,2,6]
    * Output: [4,2,6,1,3,5]
    *
    * Input: root1 = [2,1], root2 = [3,null,4]
    * Output: [3,2,4,1]
 */
public class MergeTwoBSTs {
    public static void main(String[] args) {
        // Create two BSTs
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);

        // Merge the two BSTs
        TreeNode mergedRoot = mergeTwoBSTs(root1, root2);

        // Print the merged BST in-order
        System.out.println("BST-1: ");
        printTree(root1);
        System.out.println("\nBST-2: ");
        printTree(root2);
        System.out.println("\nMerged BST in-order:");
        printTree(mergedRoot);
    }

    // This method merges two binary search trees into a single balanced binary search tree.
    static TreeNode mergeTwoBSTs(TreeNode root1, TreeNode root2){

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        ArrayList<Integer> sortedList = mergeTwoSortedList(list1,list2);
        return buildBalancedBST(sortedList,0,sortedList.size()-1);
    }

    // This method performs an in-order traversal of a binary search tree and adds the node values to a list.
    static void inorder(TreeNode root, ArrayList<Integer> list){

        if(root == null)
            return;

        //recurse left
        if(root.left != null)
            inorder(root.left, list);

        //process root
        list.add(root.val);

        //recurse right
        if(root.right != null)
            inorder(root.right,list);
    }

    // This method merges two sorted lists into a single sorted list.
    static ArrayList<Integer> mergeTwoSortedList(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> sortedList = new ArrayList<>();

        int size1 = list1.size();
        int size2 = list2.size();
        int i = 0, j = 0;
        while(i<size1 && j<size2){
            if(list1.get(i) < list2.get(j))
                sortedList.add(list1.get(i++));
            else
                sortedList.add(list2.get(j++));
        }
        while(i<size1)
            sortedList.add(list1.get(i++));
        while(j<size2)
            sortedList.add(list2.get(j++));

        return sortedList;
    }

    // This method builds a balanced binary search tree from a sorted list of integers.
    static TreeNode buildBalancedBST(ArrayList<Integer> list, int left, int right){

        if(left > right)
            return null;

        int mid = left + (right - left)/2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBalancedBST(list, left, mid-1);
        root.right = buildBalancedBST(list,mid+1, right);

        return root;
    }

    static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}

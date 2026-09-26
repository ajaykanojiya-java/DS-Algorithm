package practiceset.tree.practiceSet;

import practiceset.tree.TreeNode;

import java.util.ArrayList;

//Given a binary tree, return all paths from root to leaf.
public class PrintAllPathsOfATree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(printAllPath(root));
    }

    //Time complexity: O(n), where n is the number of nodes in the binary tree.
    //space complexity: O(h), where h is the height of the binary tree.
    public static ArrayList<ArrayList<Integer>> printAllPath(TreeNode root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(root,new ArrayList<>(), result);
        return result;
    }

    private static void helper(TreeNode node,ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result){
        if(node == null)
            return;

        if(node.left == null && node.right == null){
            slate.add(node.val);
            result.add(new ArrayList<>(slate));
            return;
        }

        //recurse left
        slate.add(node.val);
        helper(node.left,slate,result);
        slate.removeLast();

        //recurse right
        helper(node.right,slate,result);
        slate.removeLast();
    }
}

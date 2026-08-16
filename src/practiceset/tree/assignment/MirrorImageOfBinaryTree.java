package practiceset.tree.assignment;

import practiceset.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class MirrorImageOfBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        mirror_image(root);
        System.out.println("Mirror image created successfully.");
    }

    static void mirror_image(TreeNode root) {
       if(root == null)
           return;

       TreeNode temp = root.left;
       root.left = root.right;
       root.right = temp;

       mirror_image(root.left);
       mirror_image(root.right);
    }
}

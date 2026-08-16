package practiceset.tree.assignment;

import com.sun.source.tree.Tree;
import practiceset.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateSiblingPointers {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        populate_sibling_pointers(root);

        // Print the sibling pointers for each node
        populate_sibling_pointers(root);
    }
    static TreeNode populate_sibling_pointers(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode prev = null;
            for(int i=0;i<size;i++){
                //pop
                TreeNode currentNode = queue.poll();
                if(prev != null){
                    //prev.
                }
                prev = currentNode;
            }
        }
        return root;
    }
}

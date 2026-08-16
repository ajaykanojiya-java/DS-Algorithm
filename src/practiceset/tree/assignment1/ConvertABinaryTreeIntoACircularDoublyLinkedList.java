package practiceset.tree.assignment1;

import practiceset.tree.TreeNode;
/*
    * Given a binary tree, convert it into a circular doubly linked list in-place.
    * The left and right pointers in the tree nodes should be used as the previous and next pointers in the list.
    * The order of the nodes in the list should be the same as an in-order traversal of the binary tree.
    *
    * Example:
    * Input: root = [10,12,15,25,30,36]
    * Output: 25 <-> 12 <-> 30 <-> 10 <-> 36 <-> 15
    *
    *         4
    *        / \
    *       2   5
    *      / \
    *     1   3
    * In order traversal 1 -> 2 -> 3 -> 4 -> 5
    * result:
    * 1 <-> 2 <-> 3 <-> 4 <-> 5
    * ^                       |
    * |_______________________|
    * Circular means the last node should point to the first node and the first node should point to the last node.
    * 1.left = 5
    * 5.right = 1
    * left  = prev
    * right = next
 */
public class ConvertABinaryTreeIntoACircularDoublyLinkedList {
    static TreeNode prev = null;
    static TreeNode head = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        TreeNode head = convertToCircularDoublyLinkedList(root);

        // Print the circular doubly linked list
        System.out.println("Circular Doubly Linked List:");
        printCircularDoublyLinkedList(head);
    }
    static TreeNode convertToCircularDoublyLinkedList(TreeNode root) {

        inorder(root);
        //after this my prev has reached to last and head is at first so to make it circular we need to connect last and first
        prev.right = head;
        head.left = prev;
        return head;
    }

    //This method performs an in-order traversal of the binary tree and converts it into a circular doubly linked list.
    static void inorder(TreeNode root){

        if(root == null)
            return;

        //process left
        if(root.left != null)
            inorder(root.left);

        //process root
        if(prev == null)
            head = root;
        else{
            //connect the previous node with the current node
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        //process right
        inorder(root.right);
    }

    static void printCircularDoublyLinkedList(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode current = head;
        do {
            System.out.print(current.val + " ");
            current = current.right;
        } while (current != head);
    }
}

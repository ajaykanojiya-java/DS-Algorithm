package practiceset;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MergeKLists {

    public static void main(String[] args) {

        // Create sample lists
        ListNode l1 = createList(new int[]{1, 3, 5});
        ListNode l2 = createList(new int[]{3, 4});
        ListNode l3 = createList(new int[]{7});

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode result = mergeKLists(lists);

        printList(result);
    }

    static ListNode mergeKLists(ListNode[] lists) {

        //Use Min Heap to always get smallest node
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        //Add first node of each list to heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        //Dummy node helps simplify result list creation
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

         //Process heap until empty
        while (!minHeap.isEmpty()) {

            // Get smallest node
            ListNode smallest = minHeap.poll();

            // Add to result
            current.next = smallest;
            current = current.next;

            //If there is a next node in same list,push it into heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }
        return dummy.next;
    }

    // Utility: create linked list
    static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Utility: print linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

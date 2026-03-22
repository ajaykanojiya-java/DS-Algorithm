package practiceset;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
            LinkedListNode first = new LinkedListNode(1);
            first.next = new LinkedListNode(4);
            first.next.next = new LinkedListNode(5);

            LinkedListNode second = new LinkedListNode(1);
            second.next = new LinkedListNode(3);
            second.next.next = new LinkedListNode(4);

            LinkedListNode third = new LinkedListNode(2);
            third.next = new LinkedListNode(6);

            ArrayList<LinkedListNode> lists = new ArrayList<>();
            lists.add(first);
            lists.add(second);
            lists.add(third);

            LinkedListNode mergedHead = merge_k_lists(lists);
            printLinkedList(mergedHead);
    }
    static LinkedListNode merge_k_lists(ArrayList<LinkedListNode> lists) {
        // Write your code here.
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<LinkedListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        for(LinkedListNode list : lists){
            if(list != null)
                minHeap.add(list);
        }

        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode current = dummy;

        while(!minHeap.isEmpty()){
            LinkedListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if(smallest.next !=null){
                minHeap.add(smallest.next);
            }
        }
        return dummy.next;
    }

    // Utility: print linked list
    static void printLinkedList(LinkedListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    static class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

}

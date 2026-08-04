package practiceset.sorting;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Kth Largest In A Stream
Given an initial list along with another list of numbers to be appended with the initial list and an integer k, return an array consisting of the k-th largest element after adding each element from the first list to the second list.

Example
{
"k": 2,
"initial_stream": [4, 6],
"append_stream": [5, 2, 20]
}
Output:
[5, 5, 6]
Append	Stream	Sorted Stream	2nd largest
5	[4, 6, 5]	[4, 5, 6]	5
2	[4, 6, 5, 2]	[2, 4, 5, 6]	5
20	[4, 6, 5, 2, 20]	[2, 4, 5, 6, 20]	6
 */
public class KthLargetElementInString {
    public static void main(String[] args) {
        Integer k = 2;
        ArrayList<Integer> initial_stream = new ArrayList<>();
        initial_stream.add(4);
        initial_stream.add(6);

        ArrayList<Integer> append_stream = new ArrayList<>();
        append_stream.add(5);
        append_stream.add(2);
        append_stream.add(20);

        System.out.println(kth_largest(k, initial_stream, append_stream));
    }

    static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        if (initial_stream == null || append_stream == null || k <= 0) {
            return result;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Integer num : initial_stream) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        for (Integer num : append_stream) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            if (minHeap.size() >= k) {
                result.add(minHeap.peek());
            }
        }

        return result;

    }
}

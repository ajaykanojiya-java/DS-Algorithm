package practiceset.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Online Median
Given a list of numbers, the task is to insert these numbers into a stream and find the median of the stream after each insertion. If the median is a non-integer, consider it’s floor value.
The median of a sorted array is defined as the middle element when the number of elements is odd and the mean of the middle two elements when the number of elements is even.

Example
{
"stream": [3, 8, 5, 2]
}
Output:

[3, 5, 5, 4]
Iteration	Stream	Sorted Stream	Median
1	[3]	[3]	3
2	[3, 8]	[3, 8]	(3 + 8) / 2 => 5
3	[3, 8, 5]	[3, 5, 8]	5
4	[3, 8, 5, 2]	[2, 3, 5, 8]	(3 + 5) / 2 => 4
 */
public class OnlineMedian {
    public static void main(String[] args) {
        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(3);
        stream.add(8);
        stream.add(5);
        stream.add(2);
        System.out.println(online_median(stream));
    }
    //
    static ArrayList<Integer> online_median(ArrayList<Integer> stream) {

        ArrayList<Integer> result = new ArrayList<>();
        // Max Heap
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        // Min Heap
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int num : stream) {

            // Step 1
            left.offer(num);
            // Step 2
            right.offer(left.poll());
            // Step 3
            if (right.size() > left.size()) {
                left.offer(right.poll());
            }

            // Find median
            if (left.size() == right.size()) {
                result.add((left.peek() + right.peek()) / 2);
            } else {
                result.add(left.peek());
            }
        }
        return result;
    }
}

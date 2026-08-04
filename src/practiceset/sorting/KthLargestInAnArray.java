package practiceset.sorting;

import java.util.ArrayList;

/*
Given an array of integers, find the k-th largest number in it.
Example One
{
"numbers": [5, 1, 10, 3, 2],
"k": 2
}
Output:5
Example Two
{
"numbers": [4, 1, 2, 2, 3],
"k": 4
}
Output:2
 */
public class KthLargestInAnArray {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(10);
        numbers.add(3);
        numbers.add(2);
        Integer k = 2;
        System.out.println(kth_largest_in_an_array(numbers, k));
    }
    static Integer kth_largest_in_an_array(ArrayList<Integer> numbers, Integer k) {
        if (numbers == null || k <= 0 || k > numbers.size()) {
            return null;
        }
        numbers.sort((a, b) -> b - a);
        return numbers.get(k - 1);

    }
}

package practiceset.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Top K Frequent Elements
Given an integer array and a number k, find the k most frequent elements in the array.
Example One
{
"arr": [1, 2, 3, 2, 4, 3, 1],
"k": 2
}
Output:
[3, 1]

Example Two
{
"arr": [1, 2, 1, 2, 3, 1],
"k": 1
}
Output:
[1]
 */
public class TopKFrequentElement {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(3);
        arr.add(1);

        Integer k = 2;

        System.out.println(find_top_k_frequent_elements(arr, k));
    }

    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.size() == 0 || k <= 0) {
            return result;
        }

        // Count the frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a list of elements sorted by frequency
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Collect the top k frequent elements
        for (int i = 0; i < k && i < sortedEntries.size(); i++) {
            result.add(sortedEntries.get(i).getKey());
        }

        return result;

    }

}

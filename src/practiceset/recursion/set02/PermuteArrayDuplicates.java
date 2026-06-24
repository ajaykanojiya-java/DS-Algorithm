package practiceset.recursion.set02;

import java.util.*;
/*
Given an array of numbers with possible duplicates, return all of its unique permutations in any order.
Example
"arr": [1, 2, 2]
Output:[[1, 2, 2],[2, 1, 2],[2, 2, 1]]
 */
public class PermuteArrayDuplicates {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<ArrayList<Integer>> result = get_permutations(arr);
        System.out.println(result);
    }

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(arr, 0, result);
        return result;
    }

    //Time Complexity: O(n! * n) where n is the number of elements in the array.
    // The n! factor comes from the number of permutations, and the additional n factor comes from the time taken to copy each permutation into the result list.
    //Space Complexity: O(n) for the recursion stack, where n is the number of elements in the array. The space used
    static void helper(ArrayList<Integer> arr, int fixedIndex, ArrayList<ArrayList<Integer>> result) {

        // Base case
        if (fixedIndex == arr.size()) {
            result.add(new ArrayList<>(arr));
            return;
        }

        // Keep track of values already placed at this index
        Set<Integer> placed = new HashSet<>();
        for (int i = fixedIndex; i < arr.size(); i++) {
            // Skip duplicate values
            if (placed.contains(arr.get(i)))
                continue;

            placed.add(arr.get(i));
            // Choose
            Collections.swap(arr, fixedIndex, i);
            // Recurse
            helper(arr, fixedIndex + 1, result);
            // Backtrack
            Collections.swap(arr, fixedIndex, i);
        }
    }
}

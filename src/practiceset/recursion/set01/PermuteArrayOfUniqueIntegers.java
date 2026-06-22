package practiceset.recursion.set01;

import java.util.ArrayList;

/*
    * Given an array of unique integers, return all possible permutations of the array.
    * Example :
    * Input 1:
    *     A = [1, 2, 3]
    * Output 1:
    *     [ [1, 2, 3],
    *       [1, 3, 2],
    *       [2, 1, 3],
    *       [2, 3, 1],
    *       [3, 2, 1],
    *       [3, 1, 2] ]
 */
public class PermuteArrayOfUniqueIntegers {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(arr, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void helper(ArrayList<Integer> arr, int index, ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.size()) {
            result.add(new ArrayList<>(slate));
            return;
        }

        // Try each element in the array as the next element in the permutation
        for (int i = 0; i < arr.size(); i++) {
            // If the element is not already in the slate, add it and recurse
            if (!slate.contains(arr.get(i))) {
                slate.add(arr.get(i));
                helper(arr, index + 1, slate, result);
                slate.removeLast();
            }
        }
    }


}

package practiceset.recursion;

import java.util.ArrayList;

/**
 * Problem:
 * Given an integer array and a target value, return all combinations (subsets)
 * whose sum is exactly equal to the target.
 *
 * Approach:
 * Backtracking with include/exclude practiceset.recursion on a sorted input.
 * Sorting lets us skip equal values on the exclude branch so duplicate
 * combinations are not generated.
 *
 * Time Complexity: O(n * 2^n) in the worst case.
 * Space Complexity: O(n) auxiliary practiceset.recursion stack, excluding output.
 * Output Space: O(n * m), where m is the number of valid combinations.
 */
public class AllCombinationsWithSumEqualToTarget {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
//        input.add(5);
        Integer target = 3;
        System.out.println(generate_all_combinations(input, target));
    }

    static ArrayList<ArrayList<Integer>> generate_all_combinations(ArrayList<Integer> arr, Integer target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //Collections.sort(arr);
        // Start DFS from index 0 with empty slate and sum 0.
        helper(arr, target, 0,0,new ArrayList<>(),result);
        return result;
    }

    public static void helper(ArrayList<Integer> arr, Integer target, int index, int runningSum,
                              ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result){

        // Found one valid combination; copy slate because it is mutated during backtracking.
        if(runningSum == target){
            ArrayList<Integer> subset = new ArrayList<>();
            subset.addAll(slate);
            result.add(subset);
            return;
        }

        // No more elements left to decide.
        if(index == arr.size()){
            return;
        }

        // Include current element.
        slate.add(arr.get(index));
        helper(arr,target,index+1,runningSum+arr.get(index),slate,result);

        // Backtrack: undo include before exploring exclude path.
        slate.removeLast();

        // Exclude current value and skip all equal values to avoid duplicate combinations.
        int nextIndex = index + 1;
        while (nextIndex < arr.size() && arr.get(nextIndex).equals(arr.get(index))) {
            nextIndex++;
        }
        helper(arr,target,nextIndex,runningSum,slate,result);
    }

}

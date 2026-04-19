package practiceset.recursion;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Problem:
 * Given a set of integers and a target value k, determine whether there exists
 * a non-empty subset whose sum is exactly k.
 *
 * Approach:
 * Use practiceset.recursion with include/exclude decisions for each element.
 * At every index, either add the current value to runningSum or skip it.
 *
 * Time Complexity: O(2^n) in the worst case (all subset combinations are explored).
 * Space Complexity: O(n) practiceset.recursion stack depth.
 */
public class PossibleToAchieveTargetSum {

    public static void main(String[] args) {
        ArrayList<Long> input = new ArrayList<>();
        input.add(0L);
        input.add(2L);
        input.add(3L);
        input.add(4L);
        input.add(5L);
        ArrayList<Long> targetSum = new ArrayList<>();
        System.out.println(check_if_sum_possible(input, 1L));
    }

    // Entry point for subset-sum practiceset.recursion.
    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {
        return helper(arr, k, 0, 0L);
    }

    public static Boolean helper(ArrayList<Long> arr, Long k, int index, Long runningSum) {
        // Explicit edge handling for single-element input when target is zero.
        if(k==0L && arr.size() == 1 && !Objects.equals(arr.get(0), k)){
            return false;
        }

        // Base case: if current accumulated sum matches target, we found a valid subset.
        if(runningSum == k && arr.size() > 0){
            return true;
        }

        // Terminal condition: all elements are processed and no valid subset is found.
        if(index == arr.size()){
            return false;
        }

        Long value = arr.get(index);

        // Choice 1: include the current value in the subset.
        if (helper(arr, k, index + 1, runningSum + value)) {
            return true;
        }

        // Choice 2: exclude the current value and move to next index.
        return helper(arr, k, index + 1, runningSum);
    }
}

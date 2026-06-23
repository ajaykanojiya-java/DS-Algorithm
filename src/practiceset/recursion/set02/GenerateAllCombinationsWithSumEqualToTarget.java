package practiceset.recursion.set02;

import java.util.ArrayList;
import java.util.Collections;

/*
Given an integer array, generate all the unique combinations of the array numbers that sum up to a given target value.
Example One
"arr": [1, 2, 3],
"target": 3
Output:[[3],[1, 2]]

Example Two
"arr": [1, 1, 1, 1],
"target": 2
Output:[[1, 1]]
 */
public class GenerateAllCombinationsWithSumEqualToTarget {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(1);arr.add(1);
        int target = 2;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(arr);//sorting the array to handle duplicates
        result = generate_all_combinations(arr, target);
        System.out.println(result);
    }

    //Time Complexity: O(2^n) where n is the number of elements in the array.
    // In the worst case, we may have to explore all possible combinations of the array elements.
    //space Complexity: O(n) where n is the number of elements in the array.
    static ArrayList<ArrayList<Integer>> generate_all_combinations(ArrayList<Integer> arr, Integer target) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(arr, target, 0,0,new ArrayList<>(),result);
        return result;
    }

    static void helper(ArrayList<Integer> arr, Integer target, int index, int runningSum, ArrayList<Integer> slate,
                       ArrayList<ArrayList<Integer>> result){

        //base case: if runningSum is equal to target, we can add the current slate to the result
        if(runningSum == target){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(slate);
            result.add(temp);
            return;
        }

        //base case: if we have reached the end of the array or runningSum is greater then we can stop exploring this path
        if(index == arr.size() || runningSum > target){
            return;
        }

        //include part:
        slate.add(arr.get(index));
        helper(arr,target,index+1,runningSum + arr.get(index),slate,result);
        slate.remove(slate.size()-1);

        //skip duplicates: if the current element is the same as the next element, we can skip the next element to avoid duplicates
        while(index+1<arr.size() && arr.get(index) == arr.get(index+1)){
            index++;
        }

        //exclude part:
        helper(arr,target,index+1,runningSum,slate,result);

    }
}

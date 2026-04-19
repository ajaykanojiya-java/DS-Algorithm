package practiceset.recursion;

import java.util.ArrayList;

//input: [1,2,3]
//output: [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
//Time complexity: O(n*2^n) where n is the length of the input array.
// This is because there are 2^n subsets and generating each subset takes O(n) time in the worst case.
//space complexity: O(n*2^n) because we are storing all subsets in the result list, and each subset can take up to O(n) space in the worst case.
public class Subsets {

    public static void main(String[] args){
        int [] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    //function to generate all subsets of the given array
    private static ArrayList<ArrayList<Integer>> subsets(int [] nums){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    //backtracking helper function
    private static void helper(int [] nums, int index, ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result){

        //base case
        if(index == nums.length){
            result.add(new ArrayList<>(slate));
            return;
        }

        //include the current index value in the slate
        int value = nums[index];
        slate.add(value);
        helper(nums, index+1,slate,result);
        slate.remove(slate.size() - 1);

        //exclude the current index value in the slate
        helper(nums,index+1,slate,result);
    }
}

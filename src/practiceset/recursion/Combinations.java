package practiceset.recursion;


import java.util.ArrayList;

/*
Given two integers n and k, return all possible combinations of k numbers
chosen from the range [1, n].

Example 1:
Input: n = 4, k = 2
Output: [[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.

Example 2:
Input: n = 1, k = 1
Output: [[1]]

Approach: Backtracking with include/exclude decision for each candidate number.
Time Complexity: O(2^n) in the current include/exclude practiceset.recursion tree.
Space Complexity: O(n) practiceset.recursion stack (excluding output),
and O(C(n, k) * k) to store all combinations in result.
*/
public class Combinations {

    public static void main(String[] args){
        int n = 5, k = 3;
        System.out.println(combine(n, k));

    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // 'slate' keeps the current partial combination being built.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> slate = new ArrayList<>();
        helper(n, k, 0, slate, result);
        return result;
    }

    public static void helper(int n, int k, int index, ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result){

        // Pruning: if remaining available numbers + current slate size < k,
        // impossible to form a complete combination of size k. Stop this branch.
        if(slate.size() + n-index < k)
            return;

        // If we picked k numbers, capture this combination and stop this branch.
        if( slate.size()== k){
            ArrayList<Integer> subset = new ArrayList<>();
            subset.addAll(slate);
            result.add(subset);
            return;
        }

        // If all numbers from 1..n are processed, no more choices remain.
        if(index == n)
            return;

        // Include current number (index + 1), then explore deeper.
        slate.add(index+1);
        helper(n, k, index+1, slate, result);

        // Backtrack: undo the include choice before exploring exclude path.
        slate.remove(slate.size()-1);

        // Exclude current number and move to next candidate.
        helper(n,k,index+1, slate, result);
    }

}

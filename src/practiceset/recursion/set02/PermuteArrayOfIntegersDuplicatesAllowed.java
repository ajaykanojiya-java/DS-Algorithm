package practiceset.recursion.set02;

import java.util.ArrayList;
//incomplete but keeping it for reference
/*
Given an array of numbers with possible duplicates, return all of its permutations in any order.
Example
"arr": [1, 2, 2]
Output:[[1, 2, 2],[2, 1, 2],[2, 2, 1]]
 */
public class PermuteArrayOfIntegersDuplicatesAllowed {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(3);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result = get_permutations(arr);
        System.out.println(result);
    }

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(arr,0,new ArrayList<Integer>(),result);
        return result ;
    }

    static void helper(ArrayList<Integer> arr, int index, ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result){

        //base case
        if(slate.size() == arr.size()){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(slate);
            result.add(temp);
            return;
        }

        if(index == arr.size())
            return;

        //include path
        slate.add(arr.get(index));
        helper(arr,index+1,slate,result);
        slate.removeLast();

        //exclude path
        //slate.add(arr.get(index));
        helper(arr,index+1,slate,result);

    }

}

package practiceset.recursion;

import java.util.ArrayList;
import java.util.Objects;

public class CheckIfSumPossible {
    public static void main(String[] args) {
        ArrayList<Long> input = new ArrayList<>();
        input.add(0L);
//        input.add(2L);
//        input.add(3L);
//        input.add(4L);
//        input.add(5L);
        ArrayList<Long> targetSum = new ArrayList<>();
        System.out.println(check_if_sum_possible(input, 0L));
    }

    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {
        // Write your code here.
        Boolean flag = false;
        return helper(arr, k, 0, 0L, flag);

    }

    public static Boolean helper(ArrayList<Long> arr, Long k, int index, Long runningSum, Boolean flag){

        if(arr.size() == 1 && Objects.equals(arr.get(0), k)){
            return true;
        }
        if(k == 0L){
            return flag;
        }
        //base case
        if(runningSum == k){
            flag = true;
            return flag;
        }

        //terminal condition
        if(index == arr.size()){
            return flag;
        }

        //include case
        Long value = arr.get(index);
        runningSum = runningSum + value;
        flag = helper(arr, k, index+1, runningSum, flag);
        runningSum = runningSum - value;

        //exclude case
        flag = helper(arr, k, index+1, runningSum, flag);

        return flag;
    }
}

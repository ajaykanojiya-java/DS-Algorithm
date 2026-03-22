package practiceset;

import java.util.ArrayList;

public class SumInASortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        Integer target = 5;
        ArrayList<Integer> result = pair_sum_sorted_array(numbers, target);
        System.out.println(result);
    }

    static ArrayList<Integer> pair_sum_sorted_array(ArrayList<Integer> numbers, Integer target) {
        // Write your code here.
        int i=0,j=numbers.size()-1;
        int sum;
        ArrayList<Integer> result = new ArrayList<>();
        while(i<j){
            sum = numbers.get(i)+numbers.get(j);
            if (sum == target){
                    result.add(i);
                    result.add(j);
                    return result;
            }
            if(sum<target)
                i++;
            else
                j--;
        }
        result.add(-1);
        result.add(-1);
        return result;
    }
}

package practiceset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(7);
        numbers.add(11);
        numbers.add(15);
        Integer target = 26;
        ArrayList<Integer> result = two_sum(numbers, target);
        System.out.println(result);
    }
    static ArrayList<Integer> two_sum(ArrayList<Integer> numbers, Integer target) {
        // Write your code here.
        Map<Integer,Integer> complementMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<numbers.size();i++){
            if(complementMap.get(numbers.get(i))!=null){
                result.add(complementMap.get(numbers.get(i)));
                result.add(i);
                return result;
            }
            complementMap.put(target-numbers.get(i),i);
        }
        result.add(-1);
        result.add(-1);
        return result;
    }
}

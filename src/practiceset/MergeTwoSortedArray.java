package practiceset;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(2, 4, 6, 0, 0, 0));
        ArrayList<Integer> merged = merge_one_into_another(first, second);
        System.out.println(merged);
    }
    static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {
        // Write your code here.

        int lengthA = first.size()-1;
        int lengthB = second.size()-(lengthA+2);
        int lengthC = second.size()-1;

        while(lengthA>=0){
            if(lengthB>=0 && first.get(lengthA) <= second.get(lengthB)){
                second.set(lengthC,second.get(lengthB));
                lengthB--;
            }
            else{
                second.set(lengthC,first.get(lengthA));
                lengthA--;
            }
            lengthC--;
        }
        return second;
    }
}

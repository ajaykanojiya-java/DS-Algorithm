package practiceset;

import java.util.ArrayList;

public class SegregateEvenAndOddNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        ArrayList<Integer> result = segregate_evens_and_odds(numbers);
        System.out.println(result);
    }
    static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {
        // Write your code here.
        int i=0, j = numbers.size()-1;
        while(i<j){
            while(numbers.get(i)%2==0 && i<j)
                i++;
            while(numbers.get(j)%2!=0 && i<j)
                j--;
            if(i<j){
                int temp = numbers.get(i);
                numbers.set(i,numbers.get(j));
                numbers.set(j,temp);
            }
        }
        return numbers;
    }
}

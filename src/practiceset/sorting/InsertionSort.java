package practiceset.sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(11);
        arr.add(13);
        arr.add(5);
        arr.add(6);
        System.out.println(insertion_sort((ArrayList<Integer>) arr));
    }

    static ArrayList<Integer> insertion_sort(ArrayList<Integer> arr) {
        // Write your code here.

        for(int i=0;i<arr.size();i++){
            int temp = arr.get(i);
            int red = i-1;
            while(red>=0 && arr.get(red) > temp){
                arr.set(red+1,arr.get(red));
                red--;
            }
            arr.set(red+1,temp);
        }
        return arr;
    }
}


package sorting;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List arr = new ArrayList<>();
        arr.add(64);
        arr.add(25);
        arr.add(12);
        arr.add(22);
        arr.add(11);
        System.out.println(selectionSort((ArrayList<Integer>) arr));
    }
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int minValue = arr.get(i);
            int indexValue = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (minValue > arr.get(j)) {
                    minValue = arr.get(j);
                    indexValue = j;
                }
            }
            arr.set(indexValue, arr.get(i));
            arr.set(i, minValue);
        }
        return arr;
    }
}

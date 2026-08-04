package practiceset.sorting;

import java.util.ArrayList;

public class ImplementBubbleSort {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(1);
        arr.add(4);
        arr.add(2);
        arr.add(8);

        ArrayList<Integer> sortedArr = bubble_sort(arr);
        System.out.println(sortedArr);
    }

    static ArrayList<Integer> bubble_sort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        return arr;
    }
}

package practiceset.sorting;

import java.util.ArrayList;
import java.util.Random;

public class ImplementQuickSort {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(1);
        arr.add(4);
        arr.add(2);
        arr.add(8);

        ArrayList<Integer> sortedArr = quick_sort(arr);
        System.out.println(sortedArr);
    }

    static ArrayList<Integer> quick_sort(ArrayList<Integer> arr) {
        return quickSort(arr, 0, arr.size() - 1);
    }


    static ArrayList<Integer> quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }

    // This function takes last element as pivot, places the pivot element at its correct position in sorted array, and places all smaller
    // (smaller than pivot) to left of pivot and all greater elements to right of pivot
    static int partition(ArrayList<Integer> arr, int low, int high) {
        int randomIndex = low + RANDOM.nextInt(high - low + 1);
        swap(arr, randomIndex, high);
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}

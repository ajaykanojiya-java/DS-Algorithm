package practiceset.sorting;

import java.util.ArrayList;

/*
Given three arrays sorted in the ascending order, return their intersection sorted array in the ascending order.

Example One
{
"arr1": [2, 5, 10],
"arr2": [2, 3, 4, 10],
"arr3": [2, 4, 10]
}
Output: [2, 10]
Example Two
{
"arr1": [1, 2, 3],
"arr2": [],
"arr3": [2, 2]
}
Output: [-1]
Example Three
{
"arr1": [1, 2, 2, 2, 9],
"arr2": [1, 1, 2, 2],
"arr3": [1, 1, 1, 2, 2, 2]
}
Output: [1, 2, 2]
 */
public class IntersectionOfThreeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {2, 5, 10};
        int[] arr2 = {2, 3, 4, 10};
        int[] arr3 = {2, 4, 10};

        ArrayList<Integer> result = intersectionOfThreeSortedArrays(arr1, arr2, arr3);
        System.out.println("Intersection of three sorted arrays: "+result);
    }

    static ArrayList<Integer> intersectionOfThreeSortedArrays(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> intersection = new ArrayList<>();

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                intersection.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        if (intersection.isEmpty()) {
            intersection.add(-1);
        }
        return intersection;
    }
}

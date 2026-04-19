package practiceset.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(38);
        arr.add(27);
        arr.add(43);
        arr.add(3);
        arr.add(9);
        arr.add(82);
        arr.add(10);
        System.out.println(merge_sort((ArrayList<Integer>) arr));
    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        return helper(arr,0,arr.size()-1);
    }

    static ArrayList<Integer> helper(ArrayList<Integer> arr,int start, int end){
        // leaf node
        if(start == end)
            return new ArrayList<Integer>(List.of(arr.get(start)));

        //internal node worker
        int mid = (start+end)/2;
        ArrayList<Integer> left = helper(arr, start, mid);
        ArrayList<Integer> right = helper(arr, mid+1, end);

        //Merge the two sorted array
        return mergeSortedArrays(left,right);

    }

    static ArrayList<Integer> mergeSortedArrays(ArrayList<Integer> left, ArrayList<Integer> right){
        int i = 0; int j = 0;

        //aux array to store the merged sorted array
        ArrayList<Integer> auxArray = new ArrayList<Integer>();
        while(i<left.size() &&j<right.size()){
            if(left.get(i)<=right.get(j)){
                auxArray.add(left.get(i));
                i++;
            }else{
                auxArray.add(right.get(j));
                j++;
            }
        }

        //if left array is not empty, add the remaining elements to the aux array
        while(i<left.size()){
            auxArray.add(left.get(i));
            i++;
        }
        while(j<right.size()){
            auxArray.add(right.get(j));
            j++;
        }
        return auxArray;
    }
}


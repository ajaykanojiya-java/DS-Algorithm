package practiceset.sorting;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        heapSort(arr);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static void heapSort(int[] arr){

        int n = arr.length;
        for(int i = n/2-1;i>=
                0;i--){
            heapify(arr,n,i);
        }

        for(int end = n-1;end>0;end--){
            swap(arr,0,end);
            heapify(arr,end,0);
        }
    }

    private static void heapify(int [] arr, int heapSize, int root){

        int left = (2*root)+1;
        int right = (2*root)+2;
        int largest = root;

        if(left < heapSize && arr[left] > arr[largest])
            largest = left;
        if(right<heapSize && arr[right] > arr[largest])
            largest = right;

        if(largest != root){
            swap(arr,root,largest);
            heapify(arr,heapSize,largest);
        }
    }

    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

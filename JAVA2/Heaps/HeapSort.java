package Heaps;

public class HeapSort {

    public static void heapify(int arr[], int i, int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxHeap = i;

        if(left < size && arr[left] > arr[maxHeap]) {
            maxHeap = left;
        }

        if(right < size && arr[right] > arr[maxHeap]) {
            maxHeap = right;
        }

        if(maxHeap != i) {
            //swap
            int temp = arr[i];
            arr[i] = arr[maxHeap];
            arr[maxHeap] = temp;
            
            heapify(arr, maxHeap, size);
        }
    }
    
    public static void heapSort(int arr[]) {// O(n*logn)
        // step 1 - build maxHeap
        int n = arr.length;
        for(int i=n/2; i>=0; i--) {
            heapify(arr, i, n);
        }

        // step 2 - push largest at end
        for(int i=n-1; i>=0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5,3};
        heapSort(arr);
        
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

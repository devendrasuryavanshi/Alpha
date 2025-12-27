package DivideConquer;

/*
Problem: Implement Merge Sort algorithm to sort an array of integers in ascending order.

Solution:
Merge Sort is a divide-and-conquer algorithm. It divides the array into two halves, recursively sorts the two halves, and then merges the sorted halves.

Example:
Consider an array: {6, 3, 9, 5, 2, 8, 3, 6, 7, 2, -2, -8}
After sorting using Merge Sort, the array becomes: {-8, -2, 2, 2, 3, 3, 5, 6, 6, 7, 8, 9}
*/

public class DivideConquer {

    // Method to print the elements of an array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Method to perform merge sort on array elements between indices si and ei
    public static void mergeSort(int arr[], int si, int ei) {
        // Base case: If there is only one element or no element, return
        if (si >= ei) {
            return;
        }

        // Calculate the middle index
        int mid = si + (ei - si) / 2;
        // Recursively sort the left part of the array
        mergeSort(arr, si, mid);
        // Recursively sort the right part of the array
        mergeSort(arr, mid + 1, ei);
        // Merge the sorted halves
        merge(arr, si, mid, ei);
    }

    // Method to merge two sorted subarrays into one sorted array
    public static void merge(int arr[], int si, int mid, int ei) {
        // Create a temporary array to store the merged elements
        int temp[] = new int[ei - si + 1];
        // Initialize iterators for left and right parts, and temp array
        int i = si; // Iterator for left part
        int j = mid + 1; // Iterator for right part
        int k = 0; // Iterator for temp array

        // Compare elements from both parts and merge them in sorted order
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left part, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right part, if any
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy elements from temp array back to the original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    

    // public static void printArr(int arr[]) {
    //         System.out.println();
    //         for (int i = 0; i < arr.length; i++) {
    //             System.out.print(arr[i] + " ");
    //         }
    //         System.out.println();
    //     }
    
    //     public static void mergeSort(int arr[], int si, int ei) {
    //         if (si >= ei) {
    //             return;
    //         }
    //         //mid
    //         int mid = si + (ei - si) / 2;
    //         System.out.println("left");
    //         printArr(arr);
    //         //left
    //         mergeSort(arr, si, mid);
    //         System.out.println("right");
    //         printArr(arr);
    //         //right
    //         mergeSort(arr, mid + 1, ei);
    //         System.out.println("merge called");
    //         merge(arr, si, mid, ei);
    //     }
    
    //     public static void merge(int arr[], int si, int mid, int ei) {
    //         int temp[] = new int[ei - si + 1];
    //         int i = si; //iterator for left part
    //         int j = mid + 1; //iterator for right part
    //         int k = 0; //iterator for temp arr
    
    //         while (i <= mid && j <= ei) {
    //             if (arr[i] < arr[j]) {
    //                 temp[k] = arr[i];
    //                 i++;
    //             } else {
    //                 temp[k] = arr[j];
    //                 j++;
    //             }
    //             k++;
    //         }
    
    //         //left part:leftover part
    //         while (i <= mid) {
    //             temp[k++] = arr[i++];
    //         }
    
    //         //right part: leftover part
    //         while (j <= ei) {
    //             temp[k++] = arr[j++];
    //         }
    
    //         //copy temp to original arr
    //         for (k = 0, i = si; k < temp.length; k++, i++) {
    //             arr[i] = temp[k];
    //         }
    //     }
    

    // Main method to test the merge sort implementation
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}

/*
Problem: Implement Quick Sort algorithm to sort an array of integers in ascending order.

Solution:
Quick Sort is a divide-and-conquer algorithm. It divides the array into two partitions around a pivot element, recursively sorts the partitions, and combines them to get the sorted array.

Example:
Consider an array: {6, 3, 9, 5, 1, 9, 0, -4, 1}
After sorting using Quick Sort, the array becomes: {-4, 0, 1, 1, 3, 5, 6, 9, 9}
*/

package DivideConquer;

import ST.st;

public class QuickSort {

    // Method to print the elements of an array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Method to perform Quick Sort on array elements between indices si and ei
    public static void quickSort(int arr[], int si, int ei) {
        // Base case: If there is only one element or no element, return
        if (si >= ei) {
            return;
        }
        // Partition the array around a pivot element and get the pivot index
        int pIdx = partition(arr, si, ei);
        // Recursively sort the left partition
        quickSort(arr, si, pIdx - 1);
        // Recursively sort the right partition
        quickSort(arr, pIdx + 1, ei);
    }

    // Method to partition the array and return the pivot index
    public static int partition(int arr[], int si, int ei) {
        // Choose the last element as the pivot
        int pivot = arr[ei];
        int i = si - 1;

        // Iterate through the array and move elements smaller than the pivot to the left
        for (int j = si; j < ei; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap elements
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // Place the pivot element at its correct position
        i++;
        arr[ei] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void quickSort2(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }

        int pIdx = partition2(arr, si, ei);
        quickSort2(arr, si, pIdx-1);
        quickSort2(arr, pIdx+1, ei);
    }

    public static int partition2(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;
        for(int j=si; j<ei; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        arr[ei] = arr[i];
        arr[i] = pivot;
        return i;
    }

    // Main method to test the Quick Sort implementation
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 1, 9, 0, -4, 1};
        quickSort2(arr, 0, arr.length - 1);
        printArr(arr);
    }
}

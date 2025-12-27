/*
Problem: Calculate the number of inversions in an array, where an inversion is defined as a pair of indices (i, j) such that i < j and arr[i] > arr[j].

Teacher's Solution:
The teacher's solution uses a divide-and-conquer approach to count inversions by implementing a modified merge sort algorithm.

Explanation:
1. The `inversionCount` method recursively divides the array into two halves until single elements are reached.
2. During the merge step, while merging the two sorted halves, it counts inversions by comparing elements from the left and right halves.
3. If an element from the right half is smaller than an element from the left half, it indicates inversions. The count is increased by the number of remaining elements in the left half.
4. After merging, it returns the total inversion count.

Student's Solution:
The student's solution iterates through the array and swaps adjacent elements if they are out of order until the array is sorted.

Explanation:
1. The `inversionCount2` method iterates through the array and swaps adjacent elements if they are out of order.
2. It keeps track of the count of inversions by incrementing a counter each time a swap is made.
3. The iteration continues until no more swaps are needed, indicating that the array is sorted.
4. Finally, it returns the total inversion count.

Approach:
1. Teacher's solution: Utilizes the divide-and-conquer approach, which is efficient for large arrays, achieving a time complexity of O(n log n).
2. Student's solution: Employs a simple iterative approach, which may be less efficient for large arrays due to its time complexity of O(n^2).

Example:
Consider an array: {2, 4, 1, 3, 5}
Teacher's Solution:
- The sorted order of the array: {1, 2, 3, 4, 5}
- Inversions: (2, 1), (4, 1), (4, 3)
- Total inversions: 3

Student's Solution:
- After sorting: {1, 2, 3, 4, 5}
- Total inversions: 3
*/

package DivideConquer;

public class InversionCount {

    // Method to count inversions using merge sort
    public static int inversionCount(int arr[], int left, int right) {
        int invCount = 0;

        if (right > left) {
            int mid = left + (right - left) / 2;
            invCount = inversionCount(arr, left, mid);
            invCount += inversionCount(arr, mid + 1, right);
            invCount += merge(arr, left, mid + 1, right);
        }

        return invCount;
    }

    // Method to merge two sorted halves and count inversions
    public static int merge(int arr[], int left, int mid, int right) {
        int invCount = 0;
        int temp[] = new int[right - left + 1];
        int i = left;
        int j = mid;
        int k = 0;

        while (i < mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                invCount += mid - i;
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left and right parts
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy temp array back to the original array
        for (k = 0, i = left; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
        return invCount;
    }

    // Method to count inversions using iterative approach
    public static int inversionCount2(int arr[], int n, int count) {
        if (n == arr.length - 1) {
            return count;
        }

        if (arr[n] > arr[n + 1]) {
            // Swap
            int temp = arr[n];
            arr[n] = arr[n + 1];
            arr[n + 1] = temp;

            // Increment count
            count++;
            n = -1; // Reset index to start from the beginning
        }

        return inversionCount2(arr, n + 1, count);
    }

    // Main method to test the inversion count implementations
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, 0, arr.length-1));
        // System.out.println(inversionCount2(arr, 0, 0));
    }
}

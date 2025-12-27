package DivideConquer;

public class MergeSortString {

    public static void printArr(String str[]) {
        for(int i=0; i<str.length; i++) {
            System.out.print(str[i]+" ");
        }
    }

    public static void mergeSort(String str[], int si, int ei) {
        // Base case: If there is only one element or no element, return
        if(si >= ei) {
            return;
        }

        //mid
        int mid = si + (ei - si) / 2;

        //left
        mergeSort(str, si, mid);
        //right
        mergeSort(str, mid+1, ei);
        // Merge the sorted halves
        merge(str, si, mid, ei);
    }

    public static void merge(String str[], int si, int mid, int ei) {
        // Create a temporary array to store the merged elements
        String temp[] = new String[ei - si + 1];
        int i = si;
        int j = mid+1;
        int l = 0;

        while (i <= mid && j <= ei) {
            int k = 0;
            while ((str[i].length()-1 > k && str[j].length()-1 > k) && (str[i].charAt(k) == str[j].charAt(k))) {
                k++;
            }
        
            if(str[i].charAt(k)-'a' < str[j].charAt(k)-'a') {
                temp[l] = str[i];
                i++;
            } else {
                temp[l] = str[j];
                j++;
            }
            l++;

        }
        
        // Copy remaining elements from the left part, if any
        while (i <= mid) {
            temp[l++] = str[i++];
        }

        // Copy remaining elements from the right part, if any
        while (j <= ei) {
            temp[l++] = str[j++];
        }

        // Copy elements from temp array back to the original array
        for (l = 0, i = si; l < temp.length; l++, i++) {
            str[i] = temp[l];
        }
    }

    public static void mergeSortInt(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSortInt(arr, si, mid);
        mergeSortInt(arr, mid+1, ei);
        mergeInt(arr, si, mid, ei);
    }

    public static void mergeInt(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        //copy to original array
        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void mergeSort2(int arr[], int si, int ei) {
        if(si >= ei) return;

        int mid = si + (ei - si) / 2;
        mergeSort2(arr, si, mid);
        mergeSort2(arr, mid+1, ei);
        merge2(arr, si, mid, ei);
    }

    public static void merge2(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si, j = mid+1, k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid) temp[k++] = arr[i++];
        while(j <= ei) temp [k++] = arr[j++];

        for(k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    
    public static void main(String[] args) {
        String str[] = {"banana", "apple", "orange", "grape", "kiwi", "watermelon", "apple", "pineapple", "strawberry", "blueberry", "mango"};
        mergeSort(str, 0, str.length-1);
        // printArr(str);
        int arr[] = {-1,2,6,8,0,5,6,2,3,1,-5,-2,8,9,7,6};
        
        mergeSort2(arr, 0, arr.length - 1);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

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
    
    public static void main(String[] args) {
        String str[] = {"banana", "apple", "orange", "grape", "kiwi", "watermelon", "apple", "pineapple", "strawberry", "blueberry", "mango"};
        mergeSort(str, 0, str.length-1);
        printArr(str);
    }
}

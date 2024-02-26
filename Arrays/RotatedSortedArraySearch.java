package Arrays;

public class RotatedSortedArraySearch {

    public static int Rotated_Sorted_Array_Search(int arr[], int target) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = (start+end)/2;

            //comparisons
            if(arr[mid] == target) {
                return mid;
            }

            if(arr[start] <= arr[mid]) {
                if(target >= arr[start] && target <= arr[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(target <= arr[end] && target >=arr[mid]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                arr[j] = i+j > 9 ? (i+j-9)-1 : i+j;
            }
            System.out.println("-------------------------------");
            for(int k=0; k<10; k++) {
            System.out.println(arr[k]+"=="+Rotated_Sorted_Array_Search(arr, arr[k]));
            }
        }
        // System.out.println(Rotated_Sorted_Array_Search(arr, 0));
    }
}

package DivideConquer;

import java.util.Arrays;

public class MajorityElement {

    public static int majorityElement(int arr[], int max, int time, int n, int count) {
        if(n == arr.length-1) {
            if(count > time) {
                max = arr[n];
            }
            return max;
        }

        if(arr[n] == arr[n+1]) {
            count++;
        } else if(count > time) {
            max = arr[n];
            time = count;
            count = 1;
        } else {
            count = 1;
        }

        return majorityElement(arr, max, time, n+1, count);
    }
    
    public static void main(String[] args) {

        int arr[] = {2, 2, 1, 1, 1, 2, 2};
        Arrays.sort(arr);
        System.out.println(majorityElement(arr, arr[0], 0, 0, 1));
    }
}

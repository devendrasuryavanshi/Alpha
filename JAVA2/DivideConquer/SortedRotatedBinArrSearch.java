package DivideConquer;

public class SortedRotatedBinArrSearch {

    public static int sortedRotatedBinArrSearch(int arr[], int target, int si, int ei) {
        //base case
        if(si > ei) {
            return -1;
        }
        //work
        int mid = si+(ei-si)/2;

        //case found
        if(arr[mid] == target) {
            return mid;
        }

        //mid on L1
        if(arr[si] <= arr[mid]) {
            //case a : left
            if(target >= arr[si] && target <= arr[mid]) {
                ei = mid-1;
                return sortedRotatedBinArrSearch(arr, target, si, ei);
            } else {
                //case b : right
                si = mid+1;
                return sortedRotatedBinArrSearch(arr, target, si, ei);
            }
        } 
        
        //mid on L2
        else {
            //case c : right
            if(target >= arr[mid] && target <= arr[ei]) {
                si = mid+1;
                return sortedRotatedBinArrSearch(arr, target, si, ei);
            } else {
                //case d : left
                ei = mid-1;
                return sortedRotatedBinArrSearch(arr, target, si, ei);
            }
        }
    }

    public static int search(int arr[], int target) {
        int si = 0, ei = arr.length-1;
        int mid;
        while(si <= ei) {
            mid = si + (ei - si) / 2;
            if(arr[mid] == target) {
                return mid;
            }

            //L1
            if(arr[si] <= arr[mid]) {
                if(arr[si] <= target && target <= arr[mid]) {
                    ei = mid-1;
                } else {
                    si = mid+1;
                }
            }
            
            // L2
            else {
                if(arr[mid] <= target && target <= arr[ei]) {
                    si = mid+1;
                } else {
                    ei = mid-1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 0, 1, 2, 3, 4};
        System.out.println(search(arr, 8));
    }
}

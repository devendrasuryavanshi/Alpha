package BACKTRACKING;

public class BackTracking {

    public static double rec(double x, int i) {
        if(i == 1) {
            return x+(1/x);
        }

        return x+(1/rec(x, i-1));
    }

    //BackTracking on Arrays
    public static void changeArr(int arr[], int i) { // time: O(n); space: O(n)
        //base case
        if(arr.length == i) {
            printArr(arr);
            return;
        }

        //recursion
        arr[i] = i+1;
        changeArr(arr, i+1);
        arr[i] = arr[i] -2;
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    //find subsets
    public static void findSubsets(String str, String ans, int i) {
        //base case
        if(i == str.length()) {
            System.out.println(ans);
            return;
        }

        //Yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        //No choice
        findSubsets(str, ans, i+1);
    }
    
    public static void main(String[] args) {
        // int arr[] = new int[5];
        // // changeArr(arr, 0);
        // // printArr(arr);
        // String str = "abc";
        // findSubsets(str, "", 0);
        System.out.println(rec(5, 5));
    }
}

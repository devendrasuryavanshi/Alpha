package RecursionBasics;

//Recursion Started
public class RecursionBasics {
    
    // Question 1; print number in decreasing order from n to 1
    public static void printDec(int n) {
        if(n == 1) {
            System.out.print(n);
            return;
        }

        System.out.print(n+" ");
        printDec(n-1);
    }

    // Question 2; print number in Increasing order from 1 to n
    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(n+" ");
            return;
        }

        printInc(n-1);
        System.out.print(n+" ");
    }

    // Question 3; print factorial of a number n; eg. factorial of 5; 5! = 5*4*3*2*1 == 120;
    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }
        int fn = n * fact(n-1);
        return fn;
    }

    // Question 4; print sum of first n natural numbers; eg. n=5; 5+4+3+2+1 = 15;
    public static int nSum(int n) {
        if(n == 1) {
            return 1;
        }
        int fn = n + nSum(n-1);
        return fn;
    }

    // Question 5; print Nth fibonacci number; eg. 0+1 = 1+1 = 2+1 = 3+2 = 5+3 = 8+5 = 13+8 = 21 ...;
    public static int fibonacci(int Nth) {
        if(Nth == 0 || Nth == 1) {
            return Nth;
        }
        Nth = fibonacci(Nth-1) + fibonacci(Nth-2);
        return Nth;
    }

    //Question 6; check is array sorted.
    public static boolean isSorted(int arr[], int i) {
        if(i == arr.length-1) {
            return true;
        }

        if(arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }

    //Question 7; find the first occurence of an element in an Array; eg. [1, 3, 5, 7, 8, 5, 6] key=5; return indenx of first 5 which is i=2;
    public static int firstOccurence(int arr[], int key, int i) {
        if(arr[i] == key) {
            return i;
        }
        if(i == arr.length-1) {
            return -1;
        }

        return firstOccurence(arr, key, i+1);
    }

    //Question 8; find the last occurence of an element in an Array; eg. [1, 3, 5, 7, 8, 5, 6] key=5; return indenx of first 5 which is i=5;(OWN)
    public static int lastOccurence(int arr[], int key, int i) {
        if(arr[i] == key) {
            return i;
        }
        if(i == 0) {
            return -1;
        }

        return lastOccurence(arr, key, i-1);
    }

    //Question 8; find the last occurence of an element in an Array; eg. [1, 3, 5, 7, 8, 5, 6] key=5; return indenx of first 5 which is i=5;(DIDI)
    public static int lastOccurence2(int arr[], int key, int i) {
        if(i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    //Question 9; print x to the power n. 2^10 = 1024; [time: O(n), space: O(n)]
    public static int printPow(int x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * printPow(x, n-1);
    }

    //Question 10; print x to the power n in optimized. 2^10 = 1024;(OWN)
    public static int powerOpt(int x, int n, int a) {
        if(n == 0) {
            return a;
        }
        if((n&1) != 0) {
            a = a * x;
        }
        x = x * x;
        n = n>>1;
        return powerOpt(x, n, a);
    }

    //Question 10; print x to the power n in optimized. 2^10 = 1024;(DIDI)
    public static int powerOpt(int x, int n) { //O(logn)
        if(n == 0) {
            return 1;
        }
        int halfPower = powerOpt(x, n/2);
        int halfPowerSq = halfPower * halfPower;

        //n is odd
        if(n%2 != 0) {
            halfPowerSq = x * halfPowerSq;
        }
        System.out.print(halfPowerSq+" "+n+" ");
        return halfPowerSq;
    }

    public static void main(String[] args) {
        // printDec(10);
        int arr[] = {1, 2, 4, 7, 5, 3, 7, 8, 9};
        System.out.println();
    }
}

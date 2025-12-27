package LeetCode;

public class PrintNos {

    public static void printN(int n, int count) {
        if(count <= n) {
            System.out.print(count++ + " ");
            callPrint(n, count);
        }
    }

    public static void callPrint(int n, int count) {
        printN(n, count);
    }
    
    public static void main(String[] args) {
        callPrint(10, 1);
    }
}

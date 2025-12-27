package DP1;

public class TargerSum {

    // Tabulation - O(n * sum)
    public static boolean targerSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        // i = items & j = target sum
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                int v = arr[i-1];
                // include
                if(v <= j && dp[i-1][j-v]) {
                    dp[i][j] = true;
                } 
                // not include
                else if(dp[i-1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        printDp(dp);
        return dp[n][sum];
    }

    public static void printLine(int n, String s) {
        
        for(int i=0; i<n; i++) {
            System.out.print(s);
        }
        System.out.println();
    }

    public static void printDp(boolean dp[][]) {
        int n = dp.length;
        int m = dp[0].length;
        // col idx
        System.out.print("--");
        printLine(m+1, "----");
        System.out.print("|   || ");
        for(int i=0; i<m; i++) {
            if (i >= 10 && i < 100) {
                System.out.print(i + "| ");
            } else {
                System.out.print(i + " | ");
            }
        }
        System.out.println();
        System.out.print("==");
        printLine(m+1, "====");

        for(int i=0; i<dp.length; i++) {
            if(i >= 10 && i<100) {
                System.out.print("| " + i + "|| ");
            } else {
                System.out.print("| " + i + " || ");
            }
            for(int j=0; j<dp[0].length; j++) {
                if(dp[i][j]) {
                    System.out.print("T");
                } else {
                    System.out.print("F");
                }
                System.out.print(" | ");
            }
            System.out.println();
            System.out.print("--");
            printLine(m + 1, "----");
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;


        System.out.println(targerSum(arr, sum));
    }
}

package DP1;
import java.util.*;

public class Knapsack {

    // Recursion - O(2^n)
    public static int knapsack(int val[], int wt[], int capacity, int n) {
        if(capacity == 0 || n == 0) {
            return 0;
        }

        if(wt[n-1] <= capacity) {
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, capacity - wt[n - 1], n - 1);
            // not include
            int ans2 = knapsack(val, wt, capacity, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, capacity, n - 1);
        }
    }

    // Memoization - O(n * W)
    public static int knapsackMemo(int val[], int wt[], int dp[][], int W, int n) {
        if(W == 0 || n == 0) {
            return 0;
        }
        else if(dp[n][W] != -1) {// already calculated
            return dp[n][W];
        }

        if(wt[n-1] <= W) {
            // include
            int ans1 = val[n-1] + knapsackMemo(val, wt, dp, W - wt[n-1], n-1);
            // not include
            int ans2 = knapsackMemo(val, wt, dp, W, n-1);
            dp[n][W] = Math.max(ans1, ans2);
        } else {
            dp[n][W] = knapsackMemo(val, wt, dp, W, n - 1);
        }

        return dp[n][W];
    }

    // Tabulation Opt - O(n * W)
    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=0; i<dp.length; i++) {// 0th col
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++) {// 0th row
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1];// ith item val
                int w = wt[i-1];// ith item wt
                if(w <= j) {// valid
                    int incProfit = v + dp[i-1][j-w];// include
                    int excProfit = dp[i-1][j];// not include
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    dp[i][j] = dp[i - 1][j];// not include
                }
            }
        }

        printDp(dp);
        return dp[n][W];
    }

    public static void printDp(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = knapsack(val, wt, W, val.length);
        System.out.println("Recursion : " + ans);
    
        System.out.println("Memoization : " + knapsackMemo(val, wt, dp, W, val.length));

        System.out.println("Tabulation : " + knapsackTab(val, wt, W));

    }
}

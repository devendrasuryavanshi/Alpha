package DP1;
import java.util.*;

public class ClimbingStairs {

    public static int countWays(int n) {// Recursion - O(2^n)
        if(n == 0) {
            return 1;
        } else if(n < 0) {
            return 0;
        }

        return countWays(n-1) + countWays(n-2);
    }

    // Memoization(Top Down) - O(n)
    public static int countWaysMemoization(int n, int ways[]) {
        if(n == 0) {
            return 1;
        } else if(n < 0) {
            return 0;
        }
        
        if(ways[n] != -1) {// already calculated
            return ways[n];
        }

        ways[n] = countWaysMemoization(n-1, ways) + countWaysMemoization(n-2, ways);
        return ways[n];
    }

    // Tabulation(Bottom Up) - O(n)
    public static int countWaysTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            if(i == 1) {
                dp[i] = dp[i-1] + 0;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println("Recursion : " + countWays(n));
        System.out.println("Memoization : " + countWaysMemoization(n, ways));
        System.out.println("Tabulation : " + countWaysTab(n));
    }
}

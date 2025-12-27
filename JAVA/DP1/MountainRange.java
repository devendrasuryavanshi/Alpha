package DP1;

public class MountainRange {

    // Tabulation - O(n^2)
    public static int mountainRange(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;// initailize

        for(int i=2; i<=n; i++) {
            // i pairs -> mountain ranges => ci
            for(int j=0; j<i; j++) {
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside;// ci = cj*ci-j-1
            }
        }

        return dp[n];// n pairs
    }
    
    public static void main(String[] args) {
        int n = 4;
        System.out.println(mountainRange(n));
    }
}

package DP1;

import java.util.Arrays;

public class MinArrayJumps {

    // Tabulation - (OWN) -> O(n^2)
    public static int tabulation(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;// goal to goal

        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;
            for (int next=i+1; next<=i+steps && next<n; next++) {
                if(dp[next] != -1) {// nums[next] == 0;
                    ans = Math.min(ans, dp[next]);
                }
            }
            if(ans != Integer.MAX_VALUE) {// nums[i] == 0;
                dp[i] = ans + 1;
            }
        }

        return dp[0];
    }
    
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};
        System.out.println("Tabulation : " + tabulation(arr));
    }
}

package DP1;

// Catalan Number and Count BSTs
public class CatalanNum_CountBSTs {

    // Recursion - (n^n)
    public static int rec(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;// Cn
        for(int i=0; i<n; i++) {
            ans += rec(i) * rec(n-i-1);
        }

        return ans;
    }

    // Memoization - O(n^2)
    public static int memo(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }
        if(dp[n] != 0) {
            return dp[n];
        }

        int ans = 0;// Cn
        for(int i=0; i<n; i++) {
            ans += memo(i, dp) * memo(n-i-1, dp);
        }

        dp[n] = ans;
        return ans;
    }

    // Tabulation - O(n^2) (OWN)
    public static int tab(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;// initialize

        for(int i=2; i<=n; i++) {
            for(int j=0; j<i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Recuraion : " + rec(n));

        int dp[] = new int[n+1];
        System.out.println("Memoization : " + memo(n, dp));

        System.out.println("Tabulation : " + tab(n));
    }
}

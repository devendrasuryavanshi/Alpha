package DP1;

public class liveclass {

    public static int fibonnaciRec(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonnaciRec(n-1) + fibonnaciRec(n-2);
    }

    public static int fibonnaciMemo(int n, int ans[]) {

        if(n == 0 || n == 1) {
            return n;
        }

        if(ans[n] != 0) {
            return ans[n];
        }

        ans[n] = fibonnaciMemo(n-1, ans) + fibonnaciMemo(n-2, ans);
        return ans[n];
    }

    public static int fibonnaciTab(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println("Recursion : " + fibonnaciRec(12));
        System.out.println("Memoization : " + fibonnaciMemo(11, new int[12]));
        System.out.println("Tabulation : " + fibonnaciTab(21));
    }
}

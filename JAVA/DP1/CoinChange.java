package DP1;

public class CoinChange {

    // Tabulation - O(n * sum)
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        // initialize - sum id 0
        // i -> coins, j -> sum/change
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                int c = coins[i-1];
                if(c <= j) {// valid
                    dp[i][j] = dp[i][j-c] + dp[i-1][j];
                } else {// invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        printDp(dp);
        return dp[n][sum];
    }

    // Tabulation Optimized - TC & SC (OWN)
    public static int coinChangeOpt(int coins[], int sum) {
        int n = coins.length;
        int dp[] = new int[sum+1];
        dp[0] = 1;// initialize

        for(int i=1; i<n+1; i++) {
            for(int j=i; j<sum+1; j++) {
                int c = coins[i-1];
                if(c <= j) {
                    dp[j] = dp[j-c] + dp[j];
                }
            }
        }
        return dp[sum];
    }

    public static void printDp(int dp[][]) {
        int n = dp.length;
        int m = dp[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int coins[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 21;
        System.out.println("Tabulation : " + coinChange(coins, sum));
        System.out.println("Tabulation Opt : " + coinChangeOpt(coins, sum));
    }
}

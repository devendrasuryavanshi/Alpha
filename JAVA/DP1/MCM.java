package DP1;

// Matrix Chain Multiplication
public class MCM {

    // Recursion - O(2^n)
    public static int recursion(int arr[], int i, int j) {
        if(i == j) {
            return 0;// single matrix case
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int cost1 = recursion(arr, i, k);// Ai...Ak -> arr[i-1]*arr[k]
            int cost2 = recursion(arr, k+1, j);// Ak...Aj -> arr[k]*arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];// a * b * d
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return ans;// mincost
    }

    // Memoization - O(n^3)
    static int dp[][];
    public static int memoization(int arr[], int i, int j) {
        if(i == j) {
            return 0;// single matrix case
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int cost1 = memoization(arr, i, k);// Ai...Ak -> arr[i-1]*arr[k]
            int cost2 = memoization(arr, k+1, j);// Ak...Aj -> arr[k]*arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];// a * b * d
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;// mincost
    }

    // Tabulation - O(n^3)
    public static int tabulation(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // initialization
        for(int i=0; i<n; i++) {
            dp[i][i] = 0;
        }

        // bottom up
        for(int len=2; len<n; len++) {
            for(int i=1; i<=n-len; i++) {
                int j = i+len-1;// col
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        printDp(dp);
        return dp[1][n-1];
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
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        System.out.println("Recursion : " + recursion(arr, 1, n-1));

        System.out.println("Tabulation : " + tabulation(arr));
    }
}

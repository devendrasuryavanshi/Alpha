package DP1;

public class LCS2 {

    // Longest Common Substring - Tabulation -> O(n * m)
    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }// No need for 'else' since 'dp[i][j] = 0;' is already present at position i, j.
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";

        int ans = lcs(str1, str2);
        System.out.println(ans);
    }
}

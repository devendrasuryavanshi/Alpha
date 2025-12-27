package DP1;

public class WildcardMatching {

    // Wildcard Matching - Tabulation -> O(n * m) HARD
    public static boolean wildcardMatching(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];

        // initialize
        dp[0][0] = true;
        // pattern = " "
        for(int i=1; i<n+1; i++) {
            dp[i][0] = false;
        }
        // text = " "
        for(int j=1; j<m+1; j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        // bottom up
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {// match || ignore
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        printDp(dp);
        return dp[n][m];
    }

    public static void printLine(int n, String s) {

        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
        System.out.println();
    }

    public static void printDp(boolean dp[][]) {
        int n = dp.length;
        int m = dp[0].length;
        // col idx
        System.out.print("--");
        printLine(m + 1, "----");
        System.out.print("|   || ");
        for (int i = 0; i < m; i++) {
            if (i >= 10 && i < 100) {
                System.out.print(i + "| ");
            } else {
                System.out.print(i + " | ");
            }
        }
        System.out.println();
        System.out.print("==");
        printLine(m + 1, "====");

        for (int i = 0; i < dp.length; i++) {
            if (i >= 10 && i < 100) {
                System.out.print("| " + i + "|| ");
            } else {
                System.out.print("| " + i + " || ");
            }
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]) {
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
        String s = "baaabab";
        String p = "*****ba*****ab";// true
        System.out.println(wildcardMatching(s, p));
    }
}

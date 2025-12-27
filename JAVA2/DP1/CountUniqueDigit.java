package DP1;

// LeetCode - 357. Count Numbers with Unique Digits
// Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
public class CountUniqueDigit {

    public static int math(int n) {
        if(n == 0) {
            return 1;
        }
        int total = 10; 
        int prev = 9;

        for(int i=2; i<n+1; i++) {
            total += prev * (11 - i);
            prev *= 11 - i;
        }
        
        return total;
    }

    public static int dpSolution(int n) {
        int dp[] = new int[n > 2 ? n+1 : 3];
        dp[0] = 1;
        dp[1] = 10;
        dp[2] = 91;

        for(int i=3; i<n+1; i++) {
            int count = 9;
            int ans = 9;
            for(int j=1; j<i; j++) {
                ans *= count;
                count--;
            }
            dp[i] = dp[i-1] + ans;
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Math Solution : " + math(n));
        System.out.println("DP Solution : " + dpSolution(n));
    }
}

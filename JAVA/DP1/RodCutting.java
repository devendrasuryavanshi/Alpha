package DP1;

public class RodCutting {

    // Tabulation Opt - O(n * rodLength)
    public static int rodCutting(int length[], int price[], int rodLength) {
        int n = price.length;
        int dp[] = new int[rodLength+1];

        for(int i=1; i<n+1; i++) {
            for(int j=i; j<rodLength+1; j++) {
                int l = length[i-1];
                if(l <= j) {// valid
                    dp[j] = Math.max(price[i-1] + dp[j-l], dp[j]);
                }
            }
        }
        return dp[rodLength];
    }
    
    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;

        System.out.println("Tabulation : " + rodCutting(length, price, rodLength));
    }
}

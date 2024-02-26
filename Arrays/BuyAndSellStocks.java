package Arrays;

public class BuyAndSellStocks {

    public static int Buy_And_Sell_Stocks(int prices[]) {
        int length = prices.length;
        int profitOrLoss = 0;
        int value = 0;
        for(int i=0; i<length; i++) {

            for(int j=length-i-1; j>0; j--) {
                //calculate profit or loss
                value = prices[length-i-1] - prices[j-1];
                if (value > profitOrLoss) {
                    profitOrLoss = value;
                }
            }
             
        }

        return profitOrLoss;
    }

    public static int Buy_And_Sell_Stocks2(int prices[]) {
        int maxProfit = 0;
        int minBuyPrice = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {

            if(minBuyPrice < prices[i]) { //profit
                int profit = prices[i] - minBuyPrice; //today's profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                minBuyPrice = prices[i];
            }
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 2, 1};
        System.out.println(Buy_And_Sell_Stocks(prices));
        System.out.println(Buy_And_Sell_Stocks2(prices));
    }
}

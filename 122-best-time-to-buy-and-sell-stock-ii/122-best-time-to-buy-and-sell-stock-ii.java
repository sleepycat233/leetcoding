class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        int unrealizedProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[i-1]) {
                if(unrealizedProfit != 0) {
                    total += unrealizedProfit;
                    unrealizedProfit = 0;
                }
            }
            else {
                unrealizedProfit += prices[i] - prices[i-1];
            }
        }
        total += unrealizedProfit;

        return total;    }
}
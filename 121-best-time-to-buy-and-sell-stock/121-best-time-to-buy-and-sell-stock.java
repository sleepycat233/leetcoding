class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int buyi = 0, selli = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[selli]) {
                selli = i;
                if(prices[i-1] < prices[buyi]) {
                    buyi = i-1;
                }
                maxp = Math.max(maxp, prices[selli] - prices[buyi]);
            }
            else if (prices[i] < prices[buyi]) {
                buyi = selli = i;
            }
        }

        return maxp;
    }
}
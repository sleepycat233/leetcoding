class Solution {
    public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < prices.length; i++) {
            //两种选择，空仓还是持仓

            //空仓：两种操作
            //1。继续空仓-延续昨日空仓收益
            //2。卖出昨日持有的股票实现空仓
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            //持仓：两种操作
            //1. 持仓昨日的股票
            //2. 买入今日的股票
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }

        return dp[prices.length-1][0];
    }
}
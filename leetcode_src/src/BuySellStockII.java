public class BuySellStockII {
    public int maxProfit(int[] prices) {
        int total = 0;
        int unrealizedProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                if (unrealizedProfit > 0) {
                    total += unrealizedProfit;
                    unrealizedProfit = 0;
                }
            }
            else {
                unrealizedProfit += prices[i] - prices[i - 1];
            }
        }
        total += unrealizedProfit;

        return total;
    }

    // dp
    public int maxProfit2(int[] prices) {
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

    public static void main(String[] args) {
        BuySellStockII sol = new BuySellStockII();
        System.out.println(sol.maxProfit2(new int[]{1,3,2,4,6}));
        System.out.println(sol.maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(sol.maxProfit2(new int[]{1,2,3}));
        System.out.println(sol.maxProfit2(new int[]{3,2,0}));
    }
}

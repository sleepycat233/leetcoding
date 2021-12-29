// https://leetcode.com/problems/coin-change-2/

// Unbounded Knapsack

public class CoinExchange2 {
    public int exchange(int amount, int[] coins) {
        int m = amount;
        int n = coins.length;
        int[][] t = new int[n+1][m+1];

        if(amount == 0) return 1;
        // but why? it doesn't make sense. there are 0 ways to make an amout of 0, why 1??
        // 动态规划的边界是 dp[0]=1。只有当不选取任何硬币时，金额之和才为 0，因此只有 1 种硬币组合
        // ! 没有组合和有一种什么都不选的组合，不一样。
        // ex.: 10,[3,4] = 0;
        //      0,[9] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int past = 0;
                int tmp = j;

                //! duplicate calculation
                while(tmp > 0) {
                    past += t[i-1][tmp];
                    tmp -= coins[i-1];
                }

                t[i][j] = past + ((j % coins[i-1] == 0) ? 1 : 0);
            }

            for(int row = 0; row < t.length; row++)
                System.out.println(java.util.Arrays.toString(t[row]));

            System.out.println();
        }

        return t[n][m];
    }

    // optimized dp with 2d array
    public int exchange_optimized(int amount, int[] coins) {
        int m = amount;
        int n = coins.length;
        int[][] dp = new int[n][m + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;   //* 妙啊,跳过了初始化的循环
            for(int j = 1; j <= m; j++) {
                int k;
                dp[i][j] = (i == 0) ? 0 : dp[i-1][j];   //* 妙啊,省了一排dp
                if ((k = j - coins[i]) >= 0)
                    dp[i][j] += dp[i][k];
            }
        }

        for (int row = 0; row < dp.length; row++)
            System.out.println(java.util.Arrays.toString(dp[row]));

        return dp[n-1][m];
    }

    public int exchange_optimized_1d(int amount, int[] coins)
    {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin : coins) {
            /* for(int j = 1; j <= amount; j++) {
                int k;
                if((k = j-coin) >= 0)
                    dp[j] += dp[k];
            } */

            for(int j = coin; j <= amount; j++) {
                dp[j] += dp[j-coin];
            }
        }

        System.out.println(java.util.Arrays.toString(dp));

        return dp[amount];
    }
        public static void main(String[] args)
        {
            CoinExchange2 sol = new CoinExchange2();
            // System.out.println(sol.exchange(5, new int[]{1,2,5}));
            // System.out.println(sol.exchange(5, new int[]{2, 1, 3}));
            // System.out.println(sol.exchange(0, new int[]{9}));
            // System.out.println(sol.exchange_optimized(5, new int[] {2, 1, 3}));
            System.out.println(sol.exchange_optimized_1d(5, new int[] {2, 1, 3}));
        }
    }

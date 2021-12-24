// https://leetcode.com/problems/coin-change-2/

// Unbounded Knapsack

public class CoinExchange2 {
    public int exchange(int amount, int[] coins) {
        int m = amount;
        int n = coins.length;
        int[][] t = new int[n+1][m+1];

        if(amount == 0) return 1;
        // but why? it doesn't make sense. there are 0 ways to make an amout of 0, why 1??

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int past = 0;
                int tmp = j;

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

    public static void main(String[] args) {
        CoinExchange2 sol = new CoinExchange2();
        // System.out.println(sol.exchange(5, new int[]{1,2,5}));
        // System.out.println(sol.exchange(5, new int[]{2, 1, 3}));
        System.out.println(sol.exchange(0, new int[]{9}));
    }
}

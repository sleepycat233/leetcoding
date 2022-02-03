import java.util.*;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int[] t = new int[prices.length];
        int maxp = 0;
        t[0] = 0;

        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < i; j++) {
                t[i] = Math.max(t[i], prices[i] - prices[j]);
            }
            maxp = Math.max(maxp, t[i]);
        }

        return maxp;
    }

    public int maxProfit2(int[] prices) {
        int maxp = 0;
        int buyi = 0, selli = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[selli]) {
                selli = i;
                maxp = Math.max(maxp, prices[selli] - prices[buyi]);
            }
            else if (prices[i] < prices[buyi]) {
                buyi = selli = i;
            }
        }

        return maxp;
    }

    public static void main(String[] args) {
        BuySellStock sol = new BuySellStock();

        System.out.println(sol.maxProfit2(new int[]{7,1,5,3,6,4}));
    }
}

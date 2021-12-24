public class Knapsack {
    public int maxValue(int n, int[] w, int[] v, int W) {
        int[][] t = new int[n+1][W+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= W; j++) {
                if(w[i-1] > j) {
                    t[i][j] = t[i-1][j];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i-1][j-w[i-1]]+v[i-1]);
                }
            }
        }

        for(int k = 0; k < t.length; k++) {
            System.out.println(java.util.Arrays.toString(t[k]));
        }

        return t[n][W];
    }

    public static void main(String[] args) {
        int[][] items = {{4, 5}, {8, 10}, {3, 3}, {5, 2}, {2, 3}};
        int n = items.length;
        int[] w = new int[n];
        int[] v = new int[n];
        int W = 10;

        for(int i = 0; i < n; i++) {
            w[i] = items[i][0];
            v[i] = items[i][1];
        }

        Knapsack sol = new Knapsack();
        System.out.println(sol.maxValue(n,w,v,W));
    }
}

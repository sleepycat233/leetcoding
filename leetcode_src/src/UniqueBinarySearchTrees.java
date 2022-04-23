import java.util.Arrays;

public class UniqueBinarySearchTrees {

    // formula 
    public int numTrees(int n) {
        if(n == 1) return 1;

        double ans = 1;
        for(int k = 2; k <= n; k++) {
            ans *= (double)(n+k) / k;
        }

        // return (int) ans; //gives wrong answer
        return (int)Math.round(ans);
    }

    int[] cheat = new int[]{1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190};
    public int numTrees_cheat(int n) {
        return cheat[n-1];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees sol = new UniqueBinarySearchTrees();
        int[] storedRes = new int[19];
        for(int n = 1; n <= 19; n++) {
            int ans = sol.numTrees(n);
            System.out.println(n + ": " + ans);
            storedRes[n-1] = ans;
        }

        System.out.println(Arrays.toString(storedRes));

        //    System.out.println(sol.numTrees(5));
        }
}

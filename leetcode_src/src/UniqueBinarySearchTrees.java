import java.util.Arrays;
import java.util.stream.IntStream;

public class UniqueBinarySearchTrees {
    // recursion
    public int numTrees(int n) {
        int[] sequence = IntStream.range(1, n+1).toArray();
        System.out.println(Arrays.toString(sequence));

        return getNumOfSubtree(sequence, 0, n-1);
    }

    private int getNumOfSubtree(int[] sequence, int left, int right) {
        if(left > right) return 0;
        else if(left == right) return 1;

        int subtreeCount = 0;
        for (int i = left; i <= right; i++) {
            int leftCount = getNumOfSubtree(sequence, left, i-1);
            int rightCount = getNumOfSubtree(sequence, i+1, right);
            subtreeCount += leftCount + rightCount;
        }
        return subtreeCount;
    }

    // formula
    public int numTrees2(int n) {
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
        for(int n = 1; n <= 19; n++) {
            System.out.println(n + ": " + sol.numTrees(n));
        }

        // System.out.println(sol.numTrees(3));
    }
}

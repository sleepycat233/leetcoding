import java.util.Arrays;

// Optimization: using "sliding array" will give space O(1).
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] t = new int[46];
        t[0] = 1;
        t[1] = 1;

        for(int i = 2; i <= n; i++) {
            t[i] = t[i-1] + t[i-2];
        }
        System.out.println(Arrays.toString(t));
        return t[n];
    }

    public int climbStairs_cheat(int n) {
        int[] t = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903};
        return t[n];
    }

    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();
        System.out.println(sol.climbStairs(45));
    }
}
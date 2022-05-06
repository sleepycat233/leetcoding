class Solution {
    public int numTrees(int n) {
        if(n == 1) return 1;

        double ans = 1;
        for(int k = 2; k <= n; k++) {
            ans *= (double)(n+k) / k;
        }

        // return (int) ans; //gives wrong answer
        return (int)Math.round(ans);
    }
}
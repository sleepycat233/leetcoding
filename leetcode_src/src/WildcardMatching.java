import java.util.Arrays;

// https://leetcode.com/problems/wildcard-matching/

// description:
// thought process:

// time: O(m*n)
//      m+n+m*n
// space: O(m*n) - can be optimized to O(n)
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        /* boolean[][] cache = new boolean[s.length()+1][p.length()+1];
        cache[0][0] = true;

        for(int col = 1; col < cache.length; col++) {
            cache[col][0] = false;
        }

        for(int row = 1; row < cache[0].length; row++) {
            if (p.charAt(row-1) == '*')
                cache[0][row] = true;
            else
                break;
        }

        for (int col = 1; col < cache.length; col++) {
            for (int row = 1; row < cache[0].length; row++) {
                if(p.charAt(row-1) != '*') {
                    cache[col][row] = (cache[col - 1][row - 1])
                        && (s.charAt(col - 1) == p.charAt(row - 1)
                            || p.charAt(row - 1) == '?');
                }
                else {
                    cache[col][row] = cache[col-1][row] || cache[col][row-1];
                }
            }
        }

        for(boolean[] b : cache)
            System.out.println(Arrays.toString(b));

        return cache[s.length()][p.length()]; */

        int m = s.length()+1;
        int n = p.length()+1;
        boolean[][] cache = new boolean[m][n];

        cache[0][0] = true;

        for(int i = 1; i < n; i++) {
            if(p.charAt(i-1) == '*')
                cache[0][i] = true;
            else
                break;
        }

        for(int j = 1; j < m; j++) {
            for(int i = 1; i < n; i++) {
                if(p.charAt(i-1) == '*') {
                    cache[j][i] = cache[j-1][i] ||  cache[j][i-1];
                }
                else if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') {
                    cache[j][i] = cache[j-1][i-1];
                }
            }
        }

        return cache[m-1][n-1];
    }

    // wtf 1d solution runs slower & uses more memory than 2d. wtf?
    public boolean isMatch_1d(String s, String p) {
        boolean[] dp = new boolean[p.length()+1];
        dp[0] = true;   //! so that "" "" gives true

        for(int j = 1; j < dp.length && p.charAt(j-1) == '*'; j++) {
            dp[j] = true;
        }

        for(int i = 1; i <= s.length(); i++) {
            dp[0] = false;  //! so that "x" "" gives false
            boolean neighborLastRow = (i == 1);
            for(int j = 1; j < dp.length; j++) {
                boolean currLastRow = dp[j];
                char cp = p.charAt(j-1);

                if(cp == '*') {
                    dp[j] = dp[j-1] || currLastRow;
                }
                else {
                    dp[j] = (s.charAt(i-1) == cp || cp == '?') && neighborLastRow;
                }
                neighborLastRow = currLastRow;
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[p.length()];
    }

    /* public boolean isMatch_greedy(String s, String p) {
        int i = 0;  // string index
        int j = 0;  // p index
        int m = s.length();
        int n = p.length();

        while(i < m && j < n) {
            if(p.charAt(j) == '*') {
                while(j < n && p.charAt(j) == '*') ++j;
                while(i < m && s.charAt(i) != p.charAt(j)) ++i;

            }
        }
    } */

    public static void main(String[] args) {
        // System.out.println(isMatch("adceb","*a*b"));
        // System.out.println(isMatch("cb","*b"));
        // System.out.println(isMatch("cb","?b"));
        // System.out.println(isMatch("cb","?a"));

        WildcardMatching sol = new WildcardMatching();
        // System.out.println(sol.isMatch_1d("adceb", "*a*b"));
        System.out.println(sol.isMatch_1d("ab", "a*b"));
    }
}

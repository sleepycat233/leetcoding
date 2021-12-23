import java.util.Arrays;

// https://leetcode.com/problems/wildcard-matching/

// description:
// thought process:

// time: O(m*n)
//      m+n+m*n
// space: O(m*n) - can be optimized to O(n)
public class wildcard_matching {
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

        int n = p.length()+1;
        int m = s.length()+1;
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

    public static void main(String[] args) {
        System.out.println(isMatch("adceb","*a*b"));
        System.out.println(isMatch("cb","*b"));
        System.out.println(isMatch("cb","?b"));
        System.out.println(isMatch("cb","?a"));
    }
}

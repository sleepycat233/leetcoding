// https://leetcode.com/problems/regular-expression-matching/

// description:
// thought process:

public class RegularExpression {
    public static boolean isMatch(String s, String p)
    {
        boolean[][] cache = new boolean[s.length() + 1][p.length() + 1];
        cache[0][0] = true;

        for (int row = 1; row < cache[0].length; row++) {
            if (p.charAt(row - 1) == '*')
                cache[0][row] = cache[0][row-2];
        }

        for (int col = 1; col < cache.length; col++) {
            for (int row = 1; row < cache[0].length; row++) {
                if (p.charAt(row - 1) == '*') {
                    cache[col][row] = cache[col][row - 2]
                        || (cache[col - 1][row]
                            && (s.charAt(col - 1) == p.charAt(row - 2) || p.charAt(row - 2) == '.'));
                }
                else {
                    cache[col][row] = cache[col - 1][row - 1]
                        && (s.charAt(col - 1) == p.charAt(row - 1) || p.charAt(row - 1) == '.');
                }
            }
        }

        // for (boolean[] b : cache) {
        //     System.out.println(java.util.Arrays.toString(b));
        // }

        return cache[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aacb", "c*a*.b"));

    }
}

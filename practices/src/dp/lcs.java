package dp;

import java.util.*;

public class lcs {
    // longest common subsquence:
    // https://backtobackswe.com/platform/content/longest-common-subsequence/solutions

    public static String lcs_bf(String s1, String s2)
    {
        int rlen = Math.min(s1.length(), s2.length());
        char[][] r = new char[rlen][rlen + 1];
        int iocc = 0, iors = 0;

        for (int i = 0; i < s1.length(); i++) {
            int lf = -1;
            for (int j = i; j < s1.length(); j++) {
                for (int k = lf + 1; k < s2.length(); k++) {
                    if (s1.charAt(j) == s2.charAt(k)) {
                        r[iors][iocc++] = s1.charAt(j);
                        lf = k;
                        break;
                    }
                }
            }
            iors++;
            iocc = 0;
        }

        int max = 0, mi = 0;
        String s;
        for (int i = 0; i < r.length; i++) {
            // String s = String.valueOf(r[i]);

            // ? this does not work - s.length() always gives s1.length()
            // * use s.trim();

            // rlen = s.length();
            // System.out.format("s %s", s);
            // System.out.println(s.length());

            StringBuilder sb = new StringBuilder();
            for (char c : r[i]) {
                if (Character.isLetter(c)) {
                    sb.append(c);
                }
            }
            s = sb.toString();
            rlen = s.length();

            if (rlen > max) {
                max = rlen;
                mi = i;
            }
        }

        s = new String(r[mi]);
        return s.trim();
    }

    // "AGGTAB","GXTXAYB"
    public static int lcs_dp_n(String s1, String s2)
    {
        int[][] cache = new int[s2.length() + 1][s1.length() + 1];

        for (int s2col = 0; s2col < s2.length() + 1; s2col++) {
            for (int s1row = 0; s1row < s1.length() + 1; s1row++) {
                if (s1row == 0 || s2col == 0) {
                    cache[s2col][s1row] = 0;
                }
                else if (s1.charAt(s1row - 1) == s2.charAt(s2col - 1)) {
                    cache[s2col][s1row] = cache[s2col - 1][s1row - 1] + 1;
                }
                else {
                    cache[s2col][s1row] = Math.max(cache[s2col - 1][s1row], cache[s2col][s1row - 1]);
                }
            }
        }

        for (int i = 0; i < cache.length; i++) {
            System.out.println(Arrays.toString(cache[i]));
        }

        return cache[s2.length()][s1.length()];
    }

    private static String longest_of_two(String s1, String s2) {
        return s1.length() >= s2.length() ? s1 : s2;
    }

    public static String lcs_dp_str(String s1, String s2)
    {
        String[][] cache = new String[s2.length() + 1][s1.length() + 1];

        for (int s2col = 0; s2col < s2.length() + 1; s2col++) {
            for (int s1row = 0; s1row < s1.length() + 1; s1row++) {
                if (s1row == 0 || s2col == 0) {
                    cache[s2col][s1row] = "";
                }
                else if (s1.charAt(s1row - 1) == s2.charAt(s2col - 1)) {
                    cache[s2col][s1row] = cache[s2col - 1][s1row - 1] + s1.charAt(s1row - 1);
                }
                else {
                    cache[s2col][s1row] = longest_of_two(cache[s2col][s1row - 1], cache[s2col - 1][s1row]);
                }
            }
        }

        for (int i = 0; i < cache.length; i++) {
            System.out.println(Arrays.toString(cache[i]));
        }

        return cache[s2.length()][s1.length()];
    }

    // longest common substring
    // ABCD
    // BCDE

    public static int longest_common_substring_n(String s1, String s2) {
        int[][] cache = new int[s2.length()+1][s1.length()+1];
        int maxlen = 0;

        for(int s2col = 0; s2col < cache.length; s2col++) {
            for(int s1row = 0; s1row < cache[0].length; s1row++) {
                if(s2col == 0 || s1row == 0) {
                    cache[s2col][s1row] = 0;
                }
                else if(s1.charAt(s1row-1) == s2.charAt(s2col-1)) {
                    cache[s2col][s1row] = 1 + cache[s2col-1][s1row-1];
                    if (cache[s2col][s1row] > maxlen) {
                        maxlen = cache[s2col][s1row];
                    }
                }
                else {
                    cache[s2col][s1row] = 0;
                }
            }
        }

        for (int i = 0; i < cache.length; i++) {
            System.out.println(Arrays.toString(cache[i]));
        }

        return maxlen;
    }

    public static String longest_common_substring_str(String s1, String s2)
    {
        String[][] cache = new String[s2.length() + 1][s1.length() + 1];
        int maxlen = 0, maxcol = 0, maxrow = 0;

        for (int s2col = 0; s2col < cache.length; s2col++) {
            for (int s1row = 0; s1row < cache[0].length; s1row++) {
                if (s2col == 0 || s1row == 0) {
                    cache[s2col][s1row] = "";
                }
                else if (s1.charAt(s1row - 1) == s2.charAt(s2col - 1)) {
                    cache[s2col][s1row] = cache[s2col - 1][s1row - 1] + s1.charAt(s1row - 1);
                    if (cache[s2col][s1row].length() > maxlen) {
                        maxlen = cache[s2col][s1row].length();
                        maxcol = s2col;
                        maxrow = s1row;
                    }
                }
                else {
                    cache[s2col][s1row] = "";
                }
            }
        }

        for (int i = 0; i < cache.length; i++) {
            System.out.println(Arrays.toString(cache[i]));
        }

        return cache[maxcol][maxrow];
    }

    public static void main(String[] args)
    {
        // System.out.println("res: " + lcs_bf("AGGTAB","GXTXAYB"));
        // System.out.println("dp: " + lcs_dp_str("AGGTAB", "GXTXAYB"));
        // System.out.println("dp: " + longest_common_substring_n("ABCDEFG", "ABXEFGxCD"));
        System.out.println("dp: " + longest_common_substring_str("ABCDEFG", "ABXEFGxCD"));
    }
}

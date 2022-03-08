public class LongestPalindromicSubstring {
    // DABBAKK
    // brute force
    // !Time Limit Exceeded
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        String res = null;
        int ml = 0, mr = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int l = i;
                int r = j;
                boolean isPali = true;

                while(l < r) {
                    if (s.charAt(l++) != s.charAt(r--)) {
                        isPali = false;
                        break;
                    }
                }

                int lop = j-i+1;
                if(isPali && lop > len) {
                    len = lop;
                    ml = i;
                    mr = j+1;
                }
            }
        }

        res = s.substring(ml, mr);
        return res;
    }

    // dp: O(n^2) time, O(n^2) space
    // Runtime: 175 ms, faster than 38.41% of Java online submissions for Longest Palindromic Substring.
    // Memory Usage: 79.8 MB, less than 26.69% of Java online submissions for Longest Palindromic Substring.
    public String longestPalindrome2(String s)
    {
        int n = s.length();
        boolean[][] t = new boolean[n][n];
        int maxlen = 0;
        int ml = 0, mr = 0;

        if(n < 2) return s;

        for(int j = 0; j < n; j++) {
            t[j][j] = true;
            if (j != 0 && s.charAt(j) == s.charAt(j - 1)) {
                t[j][j - 1] = true;
            }

            for(int i = 0; i < j; i++) { //? or: i < j-1 -> nope
                if(t[j-1][i+1] == true && s.charAt(i) == s.charAt(j)) {
                    t[j][i] = true;
                }
                if (t[j][i] && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    ml = i;
                    mr = j;
                }
            }
        }

        return s.substring(ml, mr+1);
    }

    // dp: expand from the center
    // Runtime: 47 ms, faster than 65.64% of Java online submissions for Longest Palindromic Substring.
    // Memory Usage: 43.4 MB, less than 50.75% of Java online submissions for Longest Palindromic Substring.
    public String longestPalindrome3(String s)
    {
        int n = s.length();
        if(n < 2) return s;
        int maxlen = 1;
        int begin = 0, end = 0;

        for(int i = 1; i < n; i++) {
            int l1 = expand(s, i-1, i);
            /* if(l1 > maxlen) {
                maxlen = l1;
                end = i + l1/2 - 1;
                begin = i - l1/2;
            } */
            int l2 = expand(s, i-1, i+1);
            /* if(l2 > maxlen) {
                maxlen = l2;
                end = i + l2/2;
                begin = i - l2/2;
            } */
            int len = Math.max(l1,l2);
            if(len > maxlen) {
                maxlen = len;
                end = i + (len-1)/2; //* smart!
                begin = i - len/2;
            }
        }
        // System.out.println("begin: " + begin + ", end: " + end);
        return s.substring(begin, end+1);
    }

    private int expand(String s, int l, int r) {
        int maxlen = 0, len = 0;

        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                len = r - l + 1;
                if (len > maxlen) {
                    maxlen = len;
                }
                l--;
                r++;
            }
            else {
                break;
            }
        }
        
        return maxlen;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();

        System.out.println(sol.longestPalindrome("DABBAKK"));
        System.out.println(sol.longestPalindrome("abacdfgdcaba"));
        System.out.println(sol.longestPalindrome("a"));

        System.out.println(sol.longestPalindrome2("DABBAKK"));
        System.out.println(sol.longestPalindrome2("abacdfgdcaba"));
        System.out.println(sol.longestPalindrome2("a"));
        System.out.println(sol.longestPalindrome2("aa"));

        System.out.println(sol.longestPalindrome3("DABBAKK"));
        System.out.println(sol.longestPalindrome3("abacdfgdcaba"));
        System.out.println(sol.longestPalindrome3("a"));
        System.out.println(sol.longestPalindrome3("aa"));
        System.out.println(sol.longestPalindrome3("aaa"));
        System.out.println(sol.longestPalindrome3("aaaa"));
    }
}
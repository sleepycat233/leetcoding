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

    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();

        System.out.println(sol.longestPalindrome("DABBAKK"));
        // System.out.println(sol.longestPalindrome("abacdfgdcaba"));
        System.out.println(sol.longestPalindrome("a"));
    }
}

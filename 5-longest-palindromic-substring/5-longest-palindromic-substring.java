class Solution {
    public String longestPalindrome(String s) {
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
}
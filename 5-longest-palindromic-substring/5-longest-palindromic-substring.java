class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] t = new boolean[n][n];

        for(int j = 0; j < n; j++) {
            t[j][j] = true;
            if (j != 0 && s.charAt(j) == s.charAt(j - 1)) {
                t[j][j - 1] = true;
            }

            for(int i = 0; i < j; i++) { //? or: i < j-1
                if(t[j-1][i+1] == true && s.charAt(i) == s.charAt(j)) {
                    t[j][i] = true;
                }
            }
        }

        int maxlen = 0;
        int ml = 0, mr = 0;
        for(int j = 0; j < n; j++) {
            for(int i = 0; i <= j; i++) {
                if(t[j][i] && j-i+1 > maxlen) {
                    maxlen = j-i+1;
                    ml = i;
                    mr = j;
                }
            }
        }

        return s.substring(ml, mr+1);
    }
}
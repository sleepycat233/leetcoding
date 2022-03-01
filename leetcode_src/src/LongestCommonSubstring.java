public class LongestCommonSubstring {
    public int lcs(String s1, String s2) {
        int[][] t = new int[s1.length()+1][s2.length()+1];
        int len = 0;

        for(int j = 0; j < t[0].length; j++) {
            t[0][j] = 0;
        }

        for(int i = 1; i < t.length; i++) {
            t[i][0] = 0;
            for(int j = 1; j < t[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    t[i][j] = t[i-1][j-1]+1;
                }
                else {
                    t[i][j] = 0;
                }

                if(t[i][j] > len) {
                    len = t[i][j];
                }
            }
        }

        return len;
    }

    public static void main(String[] args) {
        LongestCommonSubstring sol = new LongestCommonSubstring();
        System.out.println(sol.lcs("ABCAD", "DABCA"));
        System.out.println(sol.lcs("ABABC", "BABCA"));
    }
}

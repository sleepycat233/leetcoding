class Solution {
    // tablution
    public int countVowelStrings(int n) {
        int[][] t = new int[n][5];
        for(int j = 0; j < 5; j++) {
            t[0][j] = j+1;
        }

        for(int i = 1; i < n; i++) {
            t[i][0] = 1;
            for(int j = 1; j < 5; j++) {
                t[i][j] = t[i-1][j] + t[i][j-1];
            }
        }

        return t[t.length-1][t[0].length-1];
    }
}
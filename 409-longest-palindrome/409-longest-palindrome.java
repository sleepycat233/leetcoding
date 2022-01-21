class Solution {
    public int longestPalindrome(String str) {
                int len = 0;
        int[] t = new int[128];

        for(int i = 0; i < str.length(); i++) {
            char c;
            t[c = str.charAt(i)]++;
            if(t[c] % 2 == 0) len+=2;
        }

        for(int x : t) {
            if(x % 2 == 1) {
                len+=1;
                break;
            }
        }

        return len;
    }
}
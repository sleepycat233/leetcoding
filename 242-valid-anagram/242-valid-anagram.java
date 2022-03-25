class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cs = countstr(s);
        int[] ct = countstr(t);
        for(int i = 0; i < cs.length; i++) {
            if(cs[i] != ct[i]) {
                return false;
            }
        }
        return true;
    }
    private int[] countstr(String str) {
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i)-97]++;
        }
        return count;
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c-'a']++;
        for(char c : t.toCharArray()) count[c-'a']--;
        for(int j = 0; j < 26; j++) {
            if(count[j] != 0) return false;
        }
        return true;
    }
}
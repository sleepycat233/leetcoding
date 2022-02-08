class Solution {
    public int firstUniqChar(String s) {
        int[] m = new int[26]; //offset 97

        for (int i = 0; i < s.length(); i++) {
            int idx = (int)s.charAt(i) - 97;
            m[idx]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (m[(int)s.charAt(i)-97] == 1)
                return i;
        }
        return -1;
    }
}
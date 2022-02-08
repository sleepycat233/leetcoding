class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> m = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int v = m.getOrDefault(c, 0);
            m.put(c, ++v);
        }

        for (int i = 0; i < s.length(); i++) {
            if(m.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
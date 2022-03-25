class Solution {
    public boolean isAnagram(String s, String t) {

        Deque<Character> stack = new LinkedList<>();
        if(s.length() != t.length()) return false;

        for(int i = 0, j = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            while(!stack.isEmpty() && stack.contains(t.charAt(j))) {
                stack.remove(t.charAt(j));
                j++;
            }
        }
        return stack.isEmpty();
    
    }
}
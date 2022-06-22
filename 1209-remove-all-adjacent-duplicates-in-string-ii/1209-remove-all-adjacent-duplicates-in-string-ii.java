class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < sb.length(); i++)
        {
            if(i == 0 || sb.charAt(i-1) != sb.charAt(i)) {
                stack.push(1);
            }
            else {
                stack.push(stack.pop() + 1);
            } 
            
            if(stack.peek() == k) {
                stack.pop();
                sb.delete(i-k+1, i+1);
                i -= k;
            }
        }
        
        return sb.toString();
    }
}
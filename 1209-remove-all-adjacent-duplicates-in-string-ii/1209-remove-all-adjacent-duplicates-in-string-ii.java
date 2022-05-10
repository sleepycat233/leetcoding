class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s); //use content of s
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < sb.length(); i++) {
            if(i == 0 || sb.charAt(i-1) != sb.charAt(i)) {
                stack.push(1);
            }
            else {
                int dupCount = stack.pop() + 1;
                if(dupCount == k) {
                    sb.delete(i-k+1, i+1);
                    i = i-k;    //* important
                }
                else {
                    stack.push(dupCount);
                }
            }
        }

        return sb.toString();
    }
}
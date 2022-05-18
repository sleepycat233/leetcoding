class Solution {
    public String removeDuplicates(String s) {
        char[] ca = s.toCharArray();
        int top = -1;
        char[] stack = new char[s.length()];

        for(int i = 0; i < ca.length; i++) {
            stack[++top] = ca[i];
            if(top != 0 && stack[top] == stack[top-1]) {
                top -= 2;
            }
        }

        return new String(stack, 0, top+1);    }
}
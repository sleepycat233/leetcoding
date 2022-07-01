class Solution {
    public boolean isValid(String str) {
        char[] ca = str.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < ca.length; i++) {
            char c = ca[i];
            if(isClosingBracket(c)) {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(!isPair(top, c)) return false;
            }
            else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean isClosingBracket(char c) {
        if(c == ')' || c == ']' || c == '}') return true;
        else return false;
    }

    private boolean isPair(char l, char r) {
        switch (l) {
            case '(':
                if (r == ')')
                    return true;
                break;
            case '[':
                if (r == ']')
                    return true;
                break;
            case '{':
                if (r == '}')
                    return true;
                break;

            default:
                break;
        }
        return false;
    }
}
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    Map<Character, Character> pairs = new HashMap<>();

    ValidParentheses() {
        this.pairs.put(')', '(');
        this.pairs.put(']', '[');
        this.pairs.put('}', '{');
    }

    public boolean isValid1(String str) {
        char[] ca = str.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < ca.length; i++) {
            char c = ca[i];
            if (pairs.containsKey(c)) {
                char left = (stack.isEmpty()) ? '#' : stack.pop();
                if (left != pairs.get(c))
                    return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    // first try - beats 8%
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

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        System.out.println(sol.isValid1("()[]"));
        System.out.println(sol.isValid1("([)]"));
        System.out.println(sol.isValid1("()["));
    }
}

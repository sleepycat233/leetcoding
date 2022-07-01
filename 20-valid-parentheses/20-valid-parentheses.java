class Solution {
    Map<Character, Character> pairs;

    public Solution() {
        pairs = new HashMap<Character, Character>();
        this.pairs.put(')', '(');
        this.pairs.put(']', '[');
        this.pairs.put('}', '{');
    }

    public boolean isValid(String str) {
        char[] ca = str.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < ca.length; i++) {
            char c = ca[i];
            if (pairs.containsKey(c)) {
                if (stack.isEmpty())
                    return false;
                char left = stack.pop();
                if (left != pairs.get(c))
                    return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
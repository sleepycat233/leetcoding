import java.util.*;
import java.util.stream.*;

public class ValidAnagram {
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

    public boolean isAnagram2(String s, String t) {
        s = sortstr(s);
        t = sortstr(t);
        return s.equals(t);
    }
    private String sortstr(String str) {
        return Stream.of(str.split("")).sorted().collect(Collectors.joining());
    }

    // O(n) time, O(1) space
    public boolean isAnagram3(String s, String t) {
        int[] cs = countstr(s);
        int[] ct = countstr(t);
        for(int i = 0; i < cs.length; i++) {
            if(cs[i] != ct[i]) {
                return false;
            }
        }
        return true;
    }
    private int[] countstr(String str) {
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i)-97]++;
        }
        return count;
    }

    public boolean isAnagram4(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c-'a']++;
        for(char c : t.toCharArray()) count[c-'a']--;
        for(int j = 0; j < 26; j++) {
            if(count[j] != 0) return false;
        }
        return true;
    }

    // Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
    // A: use hashmap instead.
    // A solution that uses the Stream API and also handles Unicode supplementary characters:
    private static String sortstr2(final String s)
    {
        return s.codePoints()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram4("ba", "ab"));
        System.out.println(sol.isAnagram4("ba", "bb"));
        System.out.println(sol.isAnagram4("bb", "ab"));
        System.out.println(sol.isAnagram4("bb", "ba"));
        System.out.println(sol.isAnagram4("dgqztusjuu", "dqugjzutsu"));
    }
}

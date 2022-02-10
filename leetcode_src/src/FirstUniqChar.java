import java.util.*;
public class FirstUniqChar {
    // Runtime: 47 ms, faster than 29.68%
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

    // Runtime: 8 ms, faster than 85.95%
    public int firstUniqChar2(String s)
    {
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

    //not working
    /*
    public int firstUniqChar3(String s) {
        int[] m = new int[26];
        int uniq = s.length();
        int lastUniq = s.length();
        for(int i = s.length()-1; i >= 0; i--) {
            int key = (int)s.charAt(i) - 97;
            if(m[key] != 0)  {
                if(uniq == m[key]) {
                    uniq = lastUniq;
                    lastUniq = s.length();
                }
                continue;
            }
            else  {
                lastUniq = uniq;
                uniq = i;
                m[key] = i;
            }
        }

        return (uniq == s.length()) ? -1 : uniq;
    }*/

    public static void main(String[] args)
    {
        FirstUniqChar sol = new FirstUniqChar();

        System.out.println(sol.firstUniqChar2("eet"));
        System.out.println(sol.firstUniqChar2("eett"));
        System.out.println(sol.firstUniqChar2("leett"));
        System.out.println(sol.firstUniqChar2("leleet"));
        System.out.println(sol.firstUniqChar2("aadadaad"));
    }
}

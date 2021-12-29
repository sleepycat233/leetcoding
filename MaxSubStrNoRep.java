// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

public class MaxSubStrNoRep {
    public int longestSubstring(String str) {
        Map<Character, Integer> m = new HashMap<>();
        Set<Character> s = new HashSet<>();
        char c;
        int v;
        int maxlen = 0;

        for(int i = 0; i < str.length(); i++) {
            if(s.add(c = str.charAt(i))) {
                m.put(c, i);
                if(s.size() > maxlen)
                    maxlen = s.size();
            } else {
                v = m.get(c);
                v++;
                s = new HashSet<>();
                while(v<=i)
                    s.add(str.charAt(v++));

                m.put(c,i);
            }

            System.out.println(Arrays.toString(s.toArray()));
        }

        return maxlen;
    }

    // sliding window - 滑动窗口
    public int longestSubstring_slidingWindow(String str) {
        Set<Character> s = new HashSet<>();
        int i = 0;
        int maxlen = 0;

        for(int j = 0; j < str.length(); j++) {
            char c;
            if(!s.add(c = str.charAt(j))) {
                while(str.charAt(i) != c) {
                    s.remove(str.charAt(i));
                    i++;
                }
            }
            if(s.size() > maxlen) maxlen = s.size();
            System.out.println(Arrays.toString(s.toArray()));
        }

        return maxlen;
    }

    public static void main(String[] args) {
        MaxSubStrNoRep sol = new MaxSubStrNoRep();

        // System.out.println(sol.longestSubstring("abcabcbb"));
        // System.out.println(sol.longestSubstring("pwwkew"));
        // System.out.println(sol.longestSubstring_slidingWindow("pwwkew"));
        // System.out.println(sol.longestSubstring_slidingWindow(" "));
        System.out.println(sol.longestSubstring_slidingWindow("aabaab!bb"));
    }
}

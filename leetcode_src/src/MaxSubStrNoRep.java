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

    // time: O(n^3)
    public int longestSubstring_bruteforce(String str) {
        int maxlen = 0;
        boolean dup = false;

        for(int i = 0; i < str.length(); i++) {
            for(int j = i; j < str.length(); j++) {
                for(int k = i; k < j; k++) {
                    if(str.charAt(j) == str.charAt(k)) {
                        dup = true;
                        break;
                    }
                }
                if(dup) {
                    if(j-i > maxlen) {
                        maxlen = j-i;
                    }
                    dup = false;
                    break;
                } else {
                    if(j-i+1 > maxlen)
                        maxlen = j-i+1;
                }
            }
        }

        return maxlen;
    }

    public int longestSubstring_bruteforce_set(String str) {
        int maxlen = 0;
        Set<Character> s = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            for(int j = i; j < str.length(); j++) {
                if(!s.add(str.charAt(j))) {
                    if(s.size() > maxlen)
                        maxlen = s.size();

                    s = new HashSet<>();
                    break;
                }
                else {
                    if(s.size() > maxlen)
                        maxlen = s.size();
                }
            }
        }

        return maxlen;
    }

    // sliding window - set - 滑动窗口
    public int longestSubstring_set(String str) {
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
                i++;    //! skip the duplicated character
            }
            if(s.size() > maxlen) maxlen = s.size();
            // System.out.println("i " + i + ", j " + j);
            // System.out.println(Arrays.toString(s.toArray()));
        }

        return maxlen;
    }

    // sliding window - map
    public int longestSubstring_map(String str)
    {
        Map<Character, Integer> m = new HashMap<>();

        char c;
        int i = 0, maxlen = 0;
        for (int j = 0; j < str.length(); j++) {
            if (m.containsKey(c = str.charAt(j))) {
                i = Math.max(m.get(c) + 1, i);
            }
            m.put(c, j);
            maxlen = Math.max(j - i + 1, maxlen);
        }
        return maxlen;
    }

    // character to integer mapping replaced with an integer array indexed by ASCII code of the character.
    public int longestSubstring_map_opt(String str) {
        int maxlen = 0;
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        for(int i = 0, j = 0; j < str.length(); j++) {
            i = Math.max(i, last[str.charAt(j)] + 1);
            maxlen = Math.max(maxlen, j-i+1);
            last[str.charAt(j)] = j;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        MaxSubStrNoRep sol = new MaxSubStrNoRep();

        // System.out.println(sol.longestSubstring("abcabcbb"));
        // System.out.println(sol.longestSubstring("pwwkew"));
        // System.out.println(sol.longestSubstring_slidingWindow("pwwkew"));
        // System.out.println(sol.longestSubstring_slidingWindow(" "));
        // System.out.println(sol.longestSubstring_slidingWindow("aabaab!bb"));
        // System.out.println(sol.longestSubstring_bruteforce("a"));
        // System.out.println(sol.longestSubstring_bruteforce(""));
        // System.out.println(sol.longestSubstring_bruteforce_set("pwwkew"));
        // System.out.println(sol.longestSubstring_map("pwwkew"));
        // System.out.println(sol.longestSubstring_set("aabaab!bb"));
        System.out.println(sol.longestSubstring_map_opt("aabaab!bb"));
    }
}

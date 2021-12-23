// https://leetcode.com/problems/two-sum/

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] n, int t) {
        Map<Integer, Integer> m = new HashMap<>();

        for(int i = 0; i < n.length; i++) {
            int d = t - n[i];
            if(m.get(n[i]) != null) {
                return new int[] {m.get(n[i])+1, i+1}; // * syntax for anonymous array
            }
            m.put(d, i);
        }

        return null;
    }

    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

    public int[] twoSum_sorted(int[] n, int t) {
        int l = 0;
        int h = n.length-1;
        int r = 0;
        while((r = n[l] + n[h]) != t) {
            if(r > t) {
                --h;
            }
            else {
                ++l;
            }
        }

        return new int[]{l+1,h+1};
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] a = {2, 3, 4, 6};
        // System.out.println(java.util.Arrays.toString(sol.twoSum(a,8)));
        System.out.println(java.util.Arrays.toString(sol.twoSum_sorted(a,8)));
    }
}

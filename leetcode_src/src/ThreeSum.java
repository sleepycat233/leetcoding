// https://leetcode.com/problems/3sum/

import java.util.*;

public class ThreeSum {
    // sort and two-pointer
    public List<List<Integer>> threeSum(int[] n) {
        Arrays.sort(n);

        List<List<Integer>> ret = new ArrayList<>();
        // int ri = 0;

        // time limit exceeded
/*         for(int l = 0; l < n.length-2; l++) {
            for(int r = l+2; r < n.length; r++) {
                for (int l = l + 1; l < r; l++) {
                    if (n[l] + n[l] + n[r] == 0) {
                        ret.add(new ArrayList<>());
                        ret.get(ri).add(n[l]);
                        ret.get(ri).add(n[l]);
                        ret.get(ri).add(n[r]);
                        ri++;
                        break;
                    }
                }
            }
        }
 */

        // time limit exceeded
        // time: O(n^3) with tree layers of nested for loop
/*         for(int l = 0; l < n.length-2; l++) {
            if(l == 0 || n[l-1] != n[l]) {
                for(int m = l+1; m < n.length-1; m++) {
                    if(m == l+1 || n[m-1] != n[m]) {
                        for(int r = m+1; r < n.length; r++) {
                            if(r == m+1 || n[r-1] != n[r]) {
                                if (n[l] + n[m] + n[r] == 0) {
                                    ret.add(new ArrayList<>());
                                    ret.get(ri).add(n[l]);
                                    ret.get(ri).add(n[m]);
                                    ret.get(ri).add(n[r]);
                                    ri++;
                                }
                            }
                        }
                    }
                }
            }
        }
 */

        for(int l = 0; l < n.length-2; l++) {
            if (l == 0 || n[l - 1] != n[l]) {
                int r = n.length-1;
                for (int m = l+1; m < n.length-1; m++) {
                    if (m == l + 1 || n[m - 1] != n[m]) {
                        int s;
                        while((s = n[l] + n[m] + n[r]) > 0 && r > m) {
                            r--;
                        }
                        if(r == m) {
                            break;
                        }
                        if(s == 0) {
                            ret.add(new ArrayList<>(Arrays.asList(n[l], n[m], n[r])));
                        }
                    }
                }
            }
        }

        return ret;
    }

    public List<List<Integer>> threeSum2(int[] n) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(n);
        // System.out.println(Arrays.toString(n));

        for(int l = 0; l < n.length-2; l++) {
            if(l != 0 && n[l-1] == n[l]) {
                continue;
            }
            int r = n.length - 1;
            for(int m = l+1; m < r; m++) {
                if(m != l+1 && n[m-1] == n[m]) {
                    continue;
                }

                int target = -(n[l] + n[m]);
                while(r > m && n[r] > target) r--;
                if(m == r) break;

                if(n[r] == target) {
                    res.add(new ArrayList<>(Arrays.asList(n[l], n[m], n[r])));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] n = { -1, 0, 1, 2, -1, -4 };
        // int[] n = {1, 2, -2, -1};
        // int[] n = {-2,-1,1,2};
        // int[] n = {-2,1,2};
        // int[] n = {-2, 0, 1, 1, 2};
        // int[] n = {-2, 0, 1, 3};
        // int[] n = {-4, 2, 4};
        // int[] n = {0,0,0,0,0};
        // int[] n = {};
        // int[] n = {-1, 0, 1, 0};
        ThreeSum sol = new ThreeSum();

        System.out.println(sol.threeSum(n));
        System.out.println(sol.threeSum2(n));

    }
}
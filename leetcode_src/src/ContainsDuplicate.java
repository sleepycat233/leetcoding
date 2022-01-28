// https://leetcode.com/problems/contains-duplicate/

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums) {
            if(!s.add(n)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
        boolean[] visited = new boolean[max - min + 1];
        for(int i = 0; i < nums.length; i++) {
            int idx = nums[i] - min;
            if(visited[idx] == true) return true;
            visited[idx] = true;
        }
        return false;
    }
}

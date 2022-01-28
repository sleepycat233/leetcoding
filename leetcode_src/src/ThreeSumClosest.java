import java.util.*;

public class ThreeSumClosest
{
    public int threeSumClosest(int[] nums, int target) {
        int dif, mindif = 1000000, sum, res = 0;

        Arrays.sort(nums);

        for(int l = 0; l < nums.length-2; l++) {
            for(int m = l+1; m < nums.length-1; m++) {
                for(int r = m+1; r < nums.length; r++) {
                    sum = nums[l] + nums[m] + nums[r];
                    dif = Math.abs(sum - target);
                    if(dif < mindif) {
                        mindif = dif;
                        res = sum;
                    }
                }
            }
        }

        return res;
    }

    // in fact not so much optimization on time complexity. still O(n^3)
    public int threeSumClosest_opt(int[] nums, int target) {
        int dif, lastdif, mindif = 1000000, sum, res = 0;

        Arrays.sort(nums);

        for(int l = 0; l < nums.length-2; l++) {
            for(int m = l+1; m < nums.length-1; m++) {
                int r = nums.length-1;
                sum = nums[l] + nums[m] + nums[r];
                dif = Math.abs(sum - target);
                lastdif = 1000000;
                while(dif <= lastdif && m < r) {
                    if (dif < mindif) {
                        mindif = dif;
                        res = sum;
                    }
                    r--;
                    lastdif = dif;
                    sum = nums[l] + nums[m] + nums[r];
                    dif = Math.abs(sum - target);
                }
            }
        }

        return res;
    }

    // two pointer
    // O(n^2)
    public int threeSumClosest_tp(int[] nums, int target) {
        int mindif = 1000000, res = 0;
        Arrays.sort(nums);
        for(int l = 0; l < nums.length-2; l++) {
            // skip duplicate
            if(l != 0 && nums[l] == nums[l-1]) {
                continue;
            }

            int m = l+1;
            int r = nums.length-1;
            while(m < r) {
                int sum = nums[l] + nums[m] + nums[r];
                int dif = Math.abs(sum - target);
                if (dif < mindif) {
                    mindif = dif;
                    res = sum;
                }
                if(sum > target) {
                    --r;
                    while(nums[r] == nums[r+1] && m < r) // skip duplicate
                        --r;
                }
                else if(sum < target) {
                    ++m;
                    while(nums[m] == nums[m-1] && m < r)
                        ++m;
                }
                else { // sum == target
                    return sum;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        ThreeSumClosest sol = new ThreeSumClosest();
        // System.out.println(sol.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        // System.out.println(sol.threeSumClosest(new int[]{-1,2,1,-4}, -3)); //-3
        // System.out.println(sol.threeSumClosest(new int[]{-5,-5,6,8,11}, -1)); //-2
        // System.out.println(sol.threeSumClosest_opt(new int[]{-5,-5,6,8,11}, -1)); //-2
        // System.out.println(sol.threeSumClosest_opt(new int[]{-3,0,1,2}, 1)); //
        // System.out.println(sol.threeSumClosest_opt(new int[]{1, 1, 48, 50, 99, 100, 103, 333, 333}, 250)); //
        System.out.println(sol.threeSumClosest_tp(new int[]{-5,-5,6,8,11}, -1)); //
    }
}
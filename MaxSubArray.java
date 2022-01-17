import java.util.*;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE, currsum = 0;
        for(int i = 0, j = 0; j < nums.length; j++) {
            if(currsum < 0) {
                // while(i != j) {
                //     currsum -= nums[i++];
                // }
                currsum = 0;
            }
            currsum += nums[j];

            if(currsum > maxsum) maxsum = currsum;
        }
        return maxsum;
    }
    public static void main(String[] args) {
        MaxSubArray sol = new MaxSubArray();
        System.out.println(sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(sol.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(sol.maxSubArray(new int[]{-1,-3}));
        System.out.println(sol.maxSubArray(new int[]{1, 2, 3}));
    }
}

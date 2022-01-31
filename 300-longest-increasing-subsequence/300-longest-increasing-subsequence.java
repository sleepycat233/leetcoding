class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n+1];
        int len = 1;
        d[len] = nums[0];

        for(int i = 1; i < n; i++) {
            if(nums[i] > d[len]) {
                d[++len] = nums[i];
            }
            else {
                int pos = 1;
                for(int j = 1; j <= len; j++) {
                    if(nums[i] <= d[j]) {
                        pos = j;
                        // d[j] = nums[i];
                        break;
                    }
                }
                d[pos] = nums[i];
            }
        }

        return len;
    }
}
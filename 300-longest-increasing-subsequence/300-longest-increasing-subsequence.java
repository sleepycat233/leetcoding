class Solution {
    public int lengthOfLIS(int[] nums) {
                int n = nums.length;
        int len = 1;
        int[] d = new int[n+1];
        d[1] = nums[0];
        //可以二分查找的条件：d[]数组为严格递增

        for(int i = 1; i < n; i++) {
            if(nums[i] > d[len]) {
                d[++len] = nums[i];
            }
            else {
                int l = 1;
                int r = len;
                int pos = 0;
                while(l <= r) {
                    int mid = (l+r)/2;
                    if(d[mid] < nums[i]) {
                        pos = mid;
                        l = mid+1;
                    }
                    else {
                        r = mid-1;
                    }
                }
                d[pos+1] = nums[i];
            }
        }
        return len;

    }
}
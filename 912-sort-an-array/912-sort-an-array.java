class Solution {
    public int[] sortArray(int[] nums) {
        for(int j = 1; j < nums.length; j++) {
            int v = nums[j];
            int i = j-1;
            while (i >= 0 && nums[i] > v) {
                nums[i+1] = nums[i];
                i--;
            }
            nums[i+1] = v;
        }

        return nums;
    }
}
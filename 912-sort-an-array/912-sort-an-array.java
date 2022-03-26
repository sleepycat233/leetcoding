class Solution {
    // mergesort
    public int[] sortArray(int[] nums) {
        return split(nums, 0, nums.length-1);
    }

    private int[] split(int[] nums, int left, int right) {
        if(left == right) {
            return new int[]{nums[left]};
        }
        else {
            int mid = (left + right) / 2;
            int[] leftSorted = split(nums, left, mid);
            int[] rightSorted = split(nums, mid+1, right);
            return merge(leftSorted, rightSorted);
        }
    }

    private int[] merge(int[] leftSorted, int[] rightSorted) {
        int m = leftSorted.length;
        int n = rightSorted.length;
        int l = 0, r = 0;
        int k = 0;
        int[] tmp = new int[m+n];

        while(l < m && r < n) {
            if(leftSorted[l] < rightSorted[r]) {
                tmp[k++] = leftSorted[l++];
            }
            else {
                tmp[k++] = rightSorted[r++];
            }
        }
        while (l < m) {
            tmp[k++] = leftSorted[l++];
        }
        while (r < n) {
            tmp[k++] = rightSorted[r++];
        }

        return tmp;
    }
}
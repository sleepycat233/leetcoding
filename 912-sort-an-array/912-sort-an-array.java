class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        return nums;
    }

    private void quicksort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        else {
            int pivot = partition(nums, l, r);
            quicksort(nums, l, pivot-1);
            quicksort(nums, pivot+1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivotv = nums[r];

        int i = l-1, j = l;
        while(j < r) {
            if(nums[j] < pivotv) {
                i++;
                swap(nums, i, j);
            }
            j++;
        }
        swap(nums, i+1, r);
        return i+1;
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
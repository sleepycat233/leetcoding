public class SortanArray_Timsort {
    public int[] sortArray(int[] nums) {
        if(nums.length < 64) binaryInsertionSort(nums);

        return nums;
    }

    private void binaryInsertionSort(int[] nums) {
        for(int j = 1; j < nums.length; j++) {
            int v = nums[j];
            int l = 0, r = j-1;
            while(l <= r) {
                int mid = (l+r)/2;
                if(nums[mid] < v) {
                    l = mid;
                }
                else {
                    r = mid;
                }
            }
        }
    }
}

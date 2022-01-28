package practice;

public class BinarySearch {
    public int bSearch(int[] nums, int n) {
        int l = 0, r = nums.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[mid] < n) {
                l = mid+1;
            }
            else {

            }
        }
        return 1;
    }
}

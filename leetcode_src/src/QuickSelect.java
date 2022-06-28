public class QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }

    public int quickSelect(int[] nums, int index, int left, int right) {
        int pivot = partition(nums, left, right);
        if(pivot == index) {
            return nums[pivot];
        }
        else {
            return pivot < index ?
                            quickSelect(nums, index, pivot+1, right) :
                            quickSelect(nums, index, left, pivot-1);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = (int)(Math.random() * (right - left + 1) + left);
        swap(nums, right, pivot);
        int x = nums[right];
        int i = left-1;
        for(int j = left; j < right; j++) {
            if(nums[j] <= x) {
                swap(nums, i+1, j);
                i++;
            }
        }
        swap(nums, i+1, right);
        return i+1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        QuickSelect sol = new QuickSelect();
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(sol.findKthLargest(nums, 2));
    }
}

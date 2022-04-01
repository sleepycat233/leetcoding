import java.util.Arrays;

public class SortanArray_MergeSortIterative {
    // mergesort
    public int[] sortArray(int[] nums)
    {
        mergesort(nums);
        return nums;
    }

    private void mergesort(int[] nums) {
        int len = 1;
        int n = nums.length;
        int i;

        while(len < n) {
            i = 0;
            while(i < n) {
                int l1 = i;
                int r1 = i+len-1;
                int l2 = i+len;
                int r2 = i+len*2-1;
                if(r1 >= n) break;
                if(r2 >= n) r2 = n-1;
                merge(nums, l1, r1, l2, r2);

                i = i+len*2;
            }
            len = len * 2;
        }
    }

    private void merge(int[] nums, int l1, int r1, int l2, int r2) {
        int[] tmp = new int[r2-l1+1];
        int i = l1, j = l2, k = 0;
        while(i <= r1 && j <= r2) {
            if(nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            }
            else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= r1) {
            tmp[k++] = nums[i++];
        }
        while (j <= r2) {
            tmp[k++] = nums[j++];
        }

        for(int m = 0; m < tmp.length; m++) {
            nums[l1 + m] = tmp[m];
        }
    }

    public static void main(String[] args)
    {
        SortanArray_MergeSortIterative sol = new SortanArray_MergeSortIterative();
        int[] arr = new int[] {9, 1, 3, 544, 2, 4, 5, 32};
        // int[] arr = new int[] {5, 3, 1};
        sol.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
